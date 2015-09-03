package com.barbon.jasperclient.service.tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.Permissions;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.service.PermissionService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;


public class PermissionsServiceTest {

    private PermissionService permissionsService;

    @Before
    public void setUpBeforeClass() throws Exception {
        final Credentials login = new Credentials("jasperadmin", "jasperadmin");
        permissionsService = new PermissionService(UtilityConstants.JASPER_SERVER_HOST_URI, login);
    }

    @Test
    public void testGetAllPermissions() {
        try {
            final Permissions permissions = permissionsService.getAllPermissions("reports", true, null, false, "user:/ajay");
            Assert.assertNotNull("The user object is not null", permissions);
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

}
