/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.service;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.User;
import uk.co.techblue.jasperclient.dto.Users;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.resource.UserResource;

/**
 * UserService.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class UserService extends AbstractService<UserResource> {

    /**
     * Instantiates a new user service.
     * 
     * @param restBaseUri the rest base uri
     * @param login the login
     */
    public UserService(final String restBaseUri, final Credentials login) {
        super(restBaseUri, login);
    }

    /*
     * @see com.barbon.jasperclient.client.Service#getResourceClass()
     */
    @Override
    protected Class<UserResource> getResourceClass() {
        return UserResource.class;
    }

    /**
     * Gets the users.
     * 
     * @return the users
     * @throws CustomException the custom exception
     */
    public Users getUsers() throws CustomException {
        final ClientResponse<Users> users = resourceProxy.searchAllUsers(authorizationInfo);
        return parseEntityFromResponse(users, CustomException.class);
    }

    /**
     * Gets the specific users.
     * 
     * @param searchString the search string
     * @return the specific users
     * @throws CustomException the custom exception
     */
    public Users getSpecificUsers(final String searchString) throws CustomException {
        final ClientResponse<Users> users = resourceProxy.searchSpecificUsers(authorizationInfo, searchString);
        return parseEntityFromResponse(users, CustomException.class);
    }

    /**
     * Gets the user.
     * 
     * @param searchUserString the search user string
     * @return the user
     * @throws CustomException the custom exception
     */
    public User getUser(final String searchUserString) throws CustomException {
        final ClientResponse<User> user = resourceProxy.searchUser(authorizationInfo, searchUserString);
        return parseEntityFromResponse(user, CustomException.class);
    }

    /**
     * Creates the user.
     * 
     * @param user the user
     * @return the user
     * @throws CustomException the custom exception
     */
    public User createUser(final User user) throws CustomException {
        final ClientResponse<User> createUserResponse = resourceProxy.createUser(authorizationInfo, user.getUsername(), user);
        return parseEntityFromResponse(createUserResponse, CustomException.class);
    }

    /**
     * Modify user.
     * 
     * @param user the user
     * @return the user
     * @throws CustomException the custom exception
     */
    public User modifyUser(final User user) throws CustomException {
        final ClientResponse<User> modifyUserResponse = resourceProxy.createUser(authorizationInfo, user.getUsername(), user);
        return parseEntityFromResponse(modifyUserResponse, CustomException.class);
    }

    /**
     * Delete user.
     * 
     * @param userIdentifier the user identifier
     * @throws CustomException the custom exception
     */
    public void deleteUser(final String userIdentifier) throws CustomException {
        final ClientResponse<String> deleteUserResponse = resourceProxy.deleteUser(authorizationInfo, userIdentifier);
        parseEntityFromResponse(deleteUserResponse, CustomException.class);
    }

}
