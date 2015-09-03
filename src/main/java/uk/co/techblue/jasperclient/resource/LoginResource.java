/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.client.Resource;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * LoginResource.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(UtilityConstants.LOGIN_SERVICE_PATH)
public interface LoginResource extends Resource {

    /**
     * Login to jasper.
     * 
     * @param username the username
     * @param password the password
     * @return the client response
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ClientResponse<String> loginToJasper(@QueryParam(UtilityConstants.JASPER_SERVER_USERNAME) String username,
        @QueryParam(UtilityConstants.JASPER_SERVER_PASSWORD) String password);

}
