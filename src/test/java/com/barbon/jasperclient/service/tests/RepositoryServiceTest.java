package com.barbon.jasperclient.service.tests;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.Folder;
import uk.co.techblue.jasperclient.dto.Patch;
import uk.co.techblue.jasperclient.dto.PatchItem;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.service.RepositoryService;
import uk.co.techblue.jasperclient.utility.UtilityConstants;

public class RepositoryServiceTest {

    private static RepositoryService repositoryService;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        final Credentials login = new Credentials("jasperadmin", "jasperadmin");
        repositoryService = new RepositoryService(UtilityConstants.JASPER_SERVER_HOST_URI, login);
    }

    @Test
    public void testGetAllRepositoryResources() {

        try {
            repositoryService.viewAllRepositoryResources(null, null, true, "reportUnit", null, true, null, 0, 0, true);
        } catch (final CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testGetRepositoryResources() {
        Folder resourceData = null;
        try {
            resourceData = repositoryService.getResourceData("reports/interactive/CustomersDataAdapter");
        } catch (final CustomException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(resourceData);
    }

    @Test
    public void testDownloadRepositoryResources() {
        File resourceDataFile = null;
        try {
            resourceDataFile = repositoryService.downloadFile("images/JRLogo");
        } catch (final CustomException e) {
            e.printStackTrace();
        }
        Assert.assertNotNull(resourceDataFile);
    }

    @Test
    public void tescreateRepositoryResourcesWithAutoId() {
        final Folder resourceData = new Folder();
        resourceData.setLabel("ReportsNewDemo");
        resourceData.setDescription("Demo folder");
        try {
            repositoryService.createResourceWithAutoId(true, "reports", resourceData);
        } catch (final CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testcreateRepositoryResource() {

        final Folder resourceData = new Folder();
        resourceData.setLabel("ReportsNewDemo");
        resourceData.setDescription("Demo folder");
        try {
            repositoryService.createModifyResource(true, "images", resourceData, true, "dishant");
        } catch (final CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void modifyRepositoryResource() {

        final PatchItem patchItem = new PatchItem();
        patchItem.setVersion(0);

        final List<Patch> patches = new ArrayList<Patch>();
        final Patch patch = new Patch();
        patch.setExpression("inputControls.add(new com.jaspersoft.jasperserver.dto.resources.ClientReference().setUri('/datatypes/decorate'))");

        final Patch patch2 = new Patch();
        patch2.setField("label");
        patch2.setValue("Modification");

        final Patch patch3 = new Patch();
        patch3.setField("query");
        patch3.setValue("/newSource");

        // patches.add(patch);
        patches.add(patch2);
        // patches.add(patch3);

        patchItem.setPatches(patches);

        try {
            repositoryService.modifyResource("newSource", patchItem);
        } catch (final CustomException e) {
            e.printStackTrace();
        }
    }

}
