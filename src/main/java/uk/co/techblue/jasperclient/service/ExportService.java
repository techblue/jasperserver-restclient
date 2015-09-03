/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.service;

import java.io.File;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.ExportServiceInput;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.resource.ExportResource;
import uk.co.techblue.jasperclient.response.ImportExportResponse;

/**
 * ExportService.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class ExportService extends AbstractService<ExportResource> {

    /**
     * Instantiates a new export service.
     * 
     * @param restBaseUri the rest base uri
     * @param login the login
     */
    public ExportService(String restBaseUri, Credentials login) {
        super(restBaseUri, login);
    }

    /*
     * @see com.barbon.jasperclient.client.Service#getResourceClass()
     */
    @Override
    protected Class<ExportResource> getResourceClass() {
        return ExportResource.class;
    }

    /**
     * Gets the object export identifier.
     * 
     * @param exportServiceInput the export service input
     * @return the object export identifier
     * @throws CustomException the custom exception
     */
    public ImportExportResponse getObjectExportIdentifier(final ExportServiceInput exportServiceInput) throws CustomException {
        final ClientResponse<ImportExportResponse> exportServiceResponse = resourceProxy.getExportIdForResource(authorizationInfo, exportServiceInput);
        return parseEntityFromResponse(exportServiceResponse, CustomException.class);
    }

    /**
     * Gets the export service status.
     * 
     * @param exportStatusIndetifier the export status indetifier
     * @return the export service status
     * @throws CustomException the custom exception
     */
    public ImportExportResponse getExportServiceStatus(final String exportStatusIndetifier) throws CustomException {
        final ClientResponse<ImportExportResponse> exportServiceRespose = resourceProxy.getExportStatus(authorizationInfo, exportStatusIndetifier);
        return parseEntityFromResponse(exportServiceRespose, CustomException.class);
    }

    /**
     * Fetch export service output.
     * 
     * @param exportStatusIndetifier the export status indetifier
     * @param fileName the file name
     * @return the file
     * @throws CustomException the custom exception
     */
    public File fetchExportServiceOutput(final String exportStatusIndetifier, final String fileName) throws CustomException {
        final ClientResponse<File> exportServiceRespose = resourceProxy.fetchExportedOutput(authorizationInfo, exportStatusIndetifier, fileName);
        return parseEntityFromResponse(exportServiceRespose, CustomException.class);
    }

}
