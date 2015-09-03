/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package com.barbon.jasperclient.service.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.Role;
import uk.co.techblue.jasperclient.dto.Roles;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.service.RoleService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

/**
 * RoleServiceTest.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class RoleServiceTest {

    /** The role service. */
    private RoleService roleService;

    /**
     * Before test execution.
     */
    @Before
    public void beforeTestExecution() {
        roleService = new RoleService(UtilityConstants.JASPER_SERVER_HOST_URI, new Credentials("jasperadmin", "jasperadmin"));
    }

    /**
     * Test search all roles.
     */
    @Test
    public void testSearchAllRoles() {
        Roles roles = null;
        try {
            roles = roleService.searchAllRoles();
        } catch (CustomException customException) {
            customException.printStackTrace();
        }
        Assert.assertNotNull(roles);
    }

    /**
     * Test search specific roles.
     */
    @Test
    public void testSearchSpecificRoles() {
        Roles roles = null;
        try {
            roles = roleService.searchSpecificRoles("User");
        } catch (CustomException customException) {
            customException.printStackTrace();
        }
        Assert.assertNotNull(roles);

    }

    /**
     * Test search role.
     */
    @Test
    public void testSearchRole() {
        Role role = null;
        try {
            role = roleService.searchRole("ROLE_DEMO");
        } catch (CustomException customException) {
            customException.printStackTrace();
        }
        Assert.assertNotNull(role);

    }

    /**
     * Test create role.
     */
    @Test
    public void testCreateRole() {
        Role role = new Role();
        role.setExternallyDefined(true);
        role.setRoleType("ROLE_DEMO");

        try {
            roleService.createRole("ROLE_DEMO", role);
        } catch (CustomException e) {

            e.printStackTrace();
        }
    }

    /**
     * Test delete role.
     */
    @Test
    public void testDeleteRole() {
        try {
            roleService.deleteRole("joeUser");
        } catch (CustomException customException) {
            customException.printStackTrace();
        }
    }

}
