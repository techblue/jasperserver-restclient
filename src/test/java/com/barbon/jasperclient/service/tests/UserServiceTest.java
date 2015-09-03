/*
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 */
package com.barbon.jasperclient.service.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.Role;
import uk.co.techblue.jasperclient.dto.RoleType;
import uk.co.techblue.jasperclient.dto.User;
import uk.co.techblue.jasperclient.dto.Users;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.service.UserService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * UserServiceTest.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class UserServiceTest {

    private UserService userService;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUpBeforeClass() throws Exception {
        final Credentials login = new Credentials("jasperadmin", "jasperadmin");
        userService = new UserService(UtilityConstants.JASPER_SERVER_HOST_URI, login);
    }

    @Test
    public void testGetAllUsers() {
        try {
            final Users users = userService.getUsers();
            Assert.assertNotNull("The user object is not null", users);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetSpevificUsers() {
        try {
            final Users users = userService.getSpecificUsers("j");
            Assert.assertNotNull("The user object is not null", users);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetparticularUser() {
        try {
            final User user = userService.getUser("kamal");
            Assert.assertNotNull("The user object is not null", user);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCreateUser() {
        try {
            final User user = new User();
            user.setEnabled(true);
            user.setFullName("ajay");
            user.setEmailAddress("ajay.deshwal@gmail.com");
            user.setPassword("ajay");
            user.setUsername("ajay");

            final List<Role> roles = new ArrayList<Role>();

            final Role role = new Role();
            role.setRoleType(RoleType.ADMINISTRATOR.getRoleType());
            roles.add(role);
            user.setRoles(roles);

            final User createdUser = userService.createUser(user);
            Assert.assertNotNull("The user object is not null", createdUser);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteUser() {
        try {
            userService.deleteUser("ajay");
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
