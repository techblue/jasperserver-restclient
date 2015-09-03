/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.service;

import java.io.File;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.resource.ImportResource;
import uk.co.techblue.jasperclient.response.ImportExportResponse;

/**
 * ImportService.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class ImportService extends AbstractService<ImportResource> {

    /**
     * Instantiates a new import service.
     * 
     * @param restBaseUri the rest base uri
     * @param login the login
     */
    public ImportService(final String restBaseUri,final Credentials login) {
        super(restBaseUri, login);
    }

    /*
     * @see com.barbon.jasperclient.client.Service#getResourceClass()
     */
    @Override
    protected Class<ImportResource> getResourceClass() {
        return ImportResource.class;
    }

    /**
     * Import resource into server.
     * 
     * @param updateExistikngResource the update existikng resource
     * @param skipUserUpdate the skip user update
     * @param includeAccessEvents the include access events
     * @param includeAduitEvents the include aduit events
     * @param includeMoniteringEvents the include monitering events
     * @param includeServerSetting the include server setting
     * @param zippedContentCatalog the zipped content catalog
     * @return the import export response
     * @throws CustomException the custom exception
     */
    public ImportExportResponse importResourceIntoServer(final boolean updateExistikngResource, final boolean skipUserUpdate, final boolean includeAccessEvents,
        final boolean includeAduitEvents, final boolean includeMoniteringEvents, final boolean includeServerSetting, final File zippedContentCatalog) throws CustomException {
        final ClientResponse<ImportExportResponse> importServiceResponse =
            resourceProxy.importResource(authorizationInfo, updateExistikngResource, skipUserUpdate, includeAccessEvents, includeAduitEvents, includeMoniteringEvents,
                includeServerSetting, zippedContentCatalog);
        return parseEntityFromResponse(importServiceResponse, CustomException.class);
    }
}
