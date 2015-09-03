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
import uk.co.techblue.jasperclient.dto.Role;
import uk.co.techblue.jasperclient.dto.Roles;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * RoleResource.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@Path(UtilityConstants.ROLE_SERVICE_PATH)
public interface RoleResource extends Resource {

    /**
     * Search all roles.
     * 
     * @param authorizationInfo the authorization info
     * @return the client response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Roles> searchAllRoles(@HeaderParam("Authorization") String authorizationInfo);

    /**
     * Search specific roles.
     * 
     * @param authorizationInformation the authorization information
     * @param searchString the search string
     * @return the client response
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Roles> searchSpecificRoles(@HeaderParam("Authorization") String authorizationInformation, @QueryParam("search") String searchString);

    /**
     * Search role.
     * 
     * @param authorizationInfo the authorization info
     * @param roleId the role id
     * @return the client response
     */
    @GET
    @Path("{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Role> searchRole(@HeaderParam("Authorization") String authorizationInfo, @PathParam("roleId") String roleId);

    /**
     * Creates the role.
     * 
     * @param authorizationinfo the authorizationinfo
     * @param userId the user id
     * @param role the role
     * @return the client response
     */
    @PUT
    @Path("{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<Role> createRole(@HeaderParam("Authorization") String authorizationinfo, @PathParam("roleId") String userId, Role role);

    /**
     * Delete role.
     * 
     * @param authorizationinfo the authorizationinfo
     * @param roleId the role id
     * @return the client response
     */
    @DELETE
    @Path("{roleId}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ClientResponse<String> deleteRole(@HeaderParam("Authorization") String authorizationinfo, @PathParam("roleId") String roleId);

}
