/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved.
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.client;

import java.lang.reflect.InvocationTargetException;

import javax.ws.rs.core.Response.Status.Family;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ClientResponseFailure;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.logging.Logger;
import org.jboss.resteasy.plugins.providers.RegisterBuiltin;
import org.jboss.resteasy.spi.ResteasyProviderFactory;

import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.response.ErrorResponse;
import uk.co.techblue.jasperclient.resteasy.provider.JasperReportProvider;

/**
 * Service.java
 * 
 * @param <RT> the generic type
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public abstract class Service<RT extends Resource> {

    /** The rest base uri. */
    protected final String restBaseUri;

    /** The resource proxy. */
    protected final RT resourceProxy;

    /** The logger. */
    private static final Logger logger = Logger.getLogger(Service.class);

    static {
        initializeProviderFactory();
    }

    private static void initializeProviderFactory() {
        try {
            final ResteasyProviderFactory providerFactory = ResteasyProviderFactory.getInstance();
            registerResteasyProvider(providerFactory, JasperReportProvider.class);
            RegisterBuiltin.register(providerFactory);
        } catch (final Exception e) {
            logger.error("Error occurred while registering custom resteasy providers", e);
        }
    }

    private static void registerResteasyProvider(final ResteasyProviderFactory providerFactory, final Class<?> providerClass) {
        logger.info("Registering custom Provider with Resteasy:" + providerClass.getName() + " ...");
        providerFactory.registerProvider(providerClass);
        logger.info("Registered custom Provider with Resteasy:" + providerClass.getName());
    }
    /**
     * Instantiates a new service.
     * 
     * @param restBaseUri the rest base uri
     */
    public Service(final String restBaseUri) {
        this.restBaseUri = restBaseUri;
        this.resourceProxy = getResourceProxy(getResourceClass(), restBaseUri);
    }

    /**
     * Gets the resource class.
     * 
     * @return the resource class
     */
    protected abstract Class<RT> getResourceClass();

    /**
     * Gets the resource proxy.
     * 
     * @param <T> the generic type
     * @param clazz the clazz
     * @param serverUri the server uri
     * @return the resource proxy
     */
    protected <T> T getResourceProxy(final Class<T> clazz,
        final String serverUri) {
        return getClientService(clazz, serverUri);
    }

    /**
     * Gets the client service.
     * 
     * @param <T> the generic type
     * @param clazz the clazz
     * @param serverUri the server uri
     * @return the client service
     */
    private final <T> T getClientService(final Class<T> clazz,
        final String serverUri) {

        return ProxyFactory.create(clazz, serverUri);
    }

    /**
     * Parses the entity from response.
     * 
     * @param <T> the generic type
     * @param <EX> the generic type
     * @param clientResponse the client response
     * @param exceptionClazz the exception clazz
     * @return the t
     * @throws EX the ex
     */
    protected <T, EX extends CustomException> T parseEntityFromResponse(
        final ClientResponse<T> clientResponse, final Class<EX> exceptionClazz)
            throws EX {
        T entity = null;
        try {
            validateResponseSuccess(clientResponse, exceptionClazz);
            entity = clientResponse.getEntity();
        } finally {
            clientResponse.releaseConnection();
        }
        return entity;
    }

    /**
     * Validate response success.
     * 
     * @param <EX> the generic type
     * @param clientResponse the client response
     * @param exceptionClazz the exception clazz
     * @throws EX the ex
     */
    protected <EX extends CustomException> void validateResponseSuccess(
        final ClientResponse<?> clientResponse, final Class<EX> exceptionClazz)
            throws EX {
        final Family statusFamily = getStatusFamily(clientResponse);
        if (statusFamily != Family.SUCCESSFUL) {
            Object errorResponse = null;
            Exception cause = null;
            try {
                errorResponse = clientResponse.getEntity(ErrorResponse.class);
                if (errorResponse == null) {
                    errorResponse = clientResponse.getEntity(String.class);
                }
            } catch (final ClientResponseFailure responseFailure) {
                cause = responseFailure;
            }
            EX exception = null;
            final String genericErrorMsg = "Error occurred while creating new instance of exception class of type "
                + exceptionClazz.getCanonicalName()
                + " to throw the following error:\n" + errorResponse;
            try {
                if (cause != null) {
                    exception = exceptionClazz.getConstructor(String.class,
                        Throwable.class).newInstance("An error occurred while fetching entity from HTTP response:\n" + errorResponse,
                            cause);
                } else {
                    exception = exceptionClazz.getConstructor(String.class)
                        .newInstance(
                            "Request processing failed.\n HTTP Status: "
                                + clientResponse
                                .getResponseStatus()
                                + "\n HTTP Status Code:"
                                + clientResponse.getStatus()
                                + " \n Error:" + errorResponse);
                }
                if (exception != null && errorResponse instanceof ErrorResponse) {
                    exception.setErrorResponse((ErrorResponse) errorResponse);
                }
            } catch (final IllegalArgumentException iae) {
                throw new IllegalStateException(genericErrorMsg, iae);
            } catch (final SecurityException se) {
                throw new IllegalStateException(genericErrorMsg, se);
            } catch (final InstantiationException ie) {
                throw new IllegalStateException(genericErrorMsg, ie);
            } catch (final IllegalAccessException iacce) {
                throw new IllegalStateException(genericErrorMsg, iacce);
            } catch (final InvocationTargetException ite) {
                throw new IllegalStateException(genericErrorMsg, ite);
            } catch (final NoSuchMethodException nsme) {
                throw new IllegalStateException(genericErrorMsg, nsme);
            }
            throw exception;
        }
    }

    /**
     * Gets the status family.
     * 
     * @param clientResponse the client response
     * @return the status family
     */
    private Family getStatusFamily(final ClientResponse<?> clientResponse) {
        Family statusFamily = null;
        if (clientResponse.getResponseStatus() == null) {
            final int statusCode = clientResponse.getStatus();
            statusFamily = getStatusFamily(statusCode);
        } else {
            statusFamily = clientResponse.getResponseStatus().getFamily();
        }
        return statusFamily;
    }

    /**
     * Gets the status family.
     * 
     * @param statusCode the status code
     * @return the status family
     */
    private Family getStatusFamily(final int statusCode) {
        Family statusFamily;
        switch (statusCode / 100) {
            case 1:
                statusFamily = Family.INFORMATIONAL;
                break;
            case 2:
                statusFamily = Family.SUCCESSFUL;
                break;
            case 3:
                statusFamily = Family.REDIRECTION;
                break;
            case 4:
                statusFamily = Family.CLIENT_ERROR;
                break;
            case 5:
                statusFamily = Family.SERVER_ERROR;
                break;
            default:
                statusFamily = Family.OTHER;
                break;
        }
        return statusFamily;
    }

}
