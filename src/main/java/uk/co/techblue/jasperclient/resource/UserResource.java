/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.client.Resource;
import uk.co.techblue.jasperclient.dto.User;
import uk.co.techblue.jasperclient.dto.Users;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * UserResource.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(UtilityConstants.USER_SERVICE_PATH)
public interface UserResource extends Resource {

    /**
     * Search all users.
     * 
     * @param authorizationInfo the authorization info
     * @return the client response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Users> searchAllUsers(@HeaderParam("Authorization") String authorizationInfo);

    /**
     * Search specific users.
     * 
     * @param authorizationInformation the authorization information
     * @param searchString the search string
     * @return the client response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Users> searchSpecificUsers(@HeaderParam("Authorization") String authorizationInformation, @QueryParam("search") String searchString);

    /**
     * Search user.
     * 
     * @param authorizationInfo the authorization info
     * @param userId the user id
     * @return the client response
     */
    @GET
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<User> searchUser(@HeaderParam("Authorization") String authorizationInfo, @PathParam("userId") String userId);

    /**
     * Creates the user.
     * 
     * @param authorizationinfo the authorizationinfo
     * @param userId the user id
     * @param user the user
     * @return the client response
     */
    @PUT
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<User> createUser(@HeaderParam("Authorization") String authorizationinfo, @PathParam("userId") String userId, User user);

    /**
     * Delete user.
     * 
     * @param authorizationinfo the authorizationinfo
     * @param userId the user id
     * @return the client response
     */
    @DELETE
    @Path("{userId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<String> deleteUser(@HeaderParam("Authorization") String authorizationinfo, @PathParam("userId") String userId);

}
