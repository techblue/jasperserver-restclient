/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.resource;

import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.client.Resource;
import uk.co.techblue.jasperclient.dto.ExportServiceInput;
import uk.co.techblue.jasperclient.response.ImportExportResponse;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * ExportResource.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(UtilityConstants.EXPORT_SERVICES_PATH)
public interface ExportResource extends Resource {

    /**
     * Gets the export id for resource.
     * 
     * @param authorizationInformation the authorization information
     * @param exportServiceInput the export service input
     * @return the export id for resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientResponse<ImportExportResponse> getExportIdForResource(@HeaderParam("Authorization") String authorizationInformation, ExportServiceInput exportServiceInput);

    /**
     * Gets the export status.
     * 
     * @param authorizationInformation the authorization information
     * @param exportIdentifier the export identifier
     * @return the export status
     */
    @GET
    @Path("{exportIdentifier}/state")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientResponse<ImportExportResponse> getExportStatus(@HeaderParam("Authorization") String authorizationInformation,
        @PathParam("exportIdentifier") String exportIdentifier);

    /**
     * Fetch exported output.
     * 
     * @param authorizationInformation the authorization information
     * @param exportIdentifier the export identifier
     * @param fileName the file name
     * @return the client response
     */
    @GET
    @Path("{exportIdentifier}/{exportedFileName}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces("application/zip")
    public ClientResponse<File> fetchExportedOutput(@HeaderParam("Authorization") String authorizationInformation, @PathParam("exportIdentifier") String exportIdentifier,
        @PathParam("exportedFileName") String fileName);

}
