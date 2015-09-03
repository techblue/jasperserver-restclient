package com.barbon.jasperclient.service.tests;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.ExportServiceInput;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.response.ImportExportResponse;
import uk.co.techblue.jasperclient.service.ExportService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;


public class ExportServiceTest {

    private static ExportService exportService;

    private static ImportExportResponse exportServiceResponse;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        final Credentials login = new Credentials("jasperadmin", "jasperadmin");
        exportService = new ExportService(UtilityConstants.JASPER_SERVER_HOST_URI, login);
    }

    @Test
    public void testGetObjectExportIdentifier() {

        final ExportServiceInput exportServiceInput = new ExportServiceInput();
        final List<String> roles = Arrays.asList("ROLE_USER", "ROLE_ADMINISTRATOR");
        final List<String> users = Arrays.asList("jasperadmin");
        final List<String> uris = Arrays.asList("/reports/interactive/TableReport");
        final List<String> parameters = Arrays.asList("role-users", "repository-permissions");

        exportServiceInput.setRoles(roles);
        exportServiceInput.setParameters(parameters);
        exportServiceInput.setUris(uris);
        exportServiceInput.setUsers(users);

        try {
            exportServiceResponse = exportService.getObjectExportIdentifier(exportServiceInput);
            System.out.println(exportServiceResponse.getServiceMessage());
        } catch (final CustomException customException) {
            customException.printStackTrace();
        }
        Assert.assertNotNull(exportServiceResponse);
    }

    @Test
    public void testGetExportStatus() {
        try {
            exportServiceResponse=exportService.getExportServiceStatus(exportServiceResponse.getServiceIdentifier());
        } catch (CustomException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Test
    public void fetchExportedOutput() {
        File file = null;
        try {
            file = exportService.fetchExportServiceOutput(exportServiceResponse.getServiceIdentifier(), "mySampleReport");
        } catch (CustomException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(file);
    }

}
