package com.barbon.jasperclient.service.tests;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.response.ImportExportResponse;
import uk.co.techblue.jasperclient.service.ImportService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;


public class ImportServiceTest {

    private static ImportService importService;
    
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        Credentials login = new Credentials("jasperadmin", "jasperadmin");
        importService = new ImportService(UtilityConstants.JASPER_SERVER_HOST_URI, login);
    }

    @Test
    public void testImportResourceIntoServer()  {
        final File zippedCatalog = new File("C://Users//dishant//Desktop//Demo.zip");

        ImportExportResponse importExportResponse;
        try {
            importExportResponse = importService.importResourceIntoServer(true, true, true, true, true, true,
                zippedCatalog);
            System.out.println(importExportResponse.getServicePhase());
        } catch (CustomException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        

    }
}
