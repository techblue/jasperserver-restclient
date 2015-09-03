/*******************************************************************************
 * Copyright 2015, Techblue Software Pvt Ltd. All Rights Reserved.
 * No part of this content may be used without Techblue's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.service;

import java.io.File;

import org.jboss.resteasy.client.ClientResponse;

import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.dto.Folder;
import uk.co.techblue.jasperclient.dto.PatchItem;
import uk.co.techblue.jasperclient.dto.Resources;
import uk.co.techblue.jasperclient.exception.CustomException;
import uk.co.techblue.jasperclient.resource.RepositoryResource;

/**
 * RepositoryService.java
 *
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class RepositoryService extends AbstractService<RepositoryResource> {

    /**
     * Instantiates a new repository service.
     *
     * @param restBaseUri the rest base uri
     * @param login the login
     */
    public RepositoryService(final String restBaseUri, final Credentials login) {
        super(restBaseUri, login);
    }

    /*
     * @see com.barbon.jasperclient.client.Service#getResourceClass()
     */
    @Override
    protected Class<RepositoryResource> getResourceClass() {
        return RepositoryResource.class;
    }

    /**
     * Gets the resource data.
     *
     * @param resourcePath the resource path
     * @return the resource data
     * @throws CustomException the custom exception
     */
    public Folder getResourceData(final String resourcePath) throws CustomException {
        final ClientResponse<Folder> repositoryServiceResponse = resourceProxy.getFileResource(authorizationInfo, resourcePath);
        return parseEntityFromResponse(repositoryServiceResponse, CustomException.class);
    }

    /**
     * Download file.
     *
     * @param resourcePath the resource path
     * @return the file
     * @throws CustomException the custom exception
     */
    public File downloadFile(final String resourcePath) throws CustomException {
        final ClientResponse<File> repositoryServiceResponse = resourceProxy.downloadFileResource(authorizationInfo, resourcePath);
        return parseEntityFromResponse(repositoryServiceResponse, CustomException.class);
    }

    /**
     * Creates the resource with auto id.
     *
     * @param createFolder the create folder
     * @param resourcePath the resource path
     * @param resourceData the resource data
     * @throws CustomException the custom exception
     */
    public void createResourceWithAutoId(final boolean createFolder, final String resourcePath, final Folder resourceData) throws CustomException {
        final ClientResponse<String> createdResource = resourceProxy.createFolderWithAutoId(authorizationInfo, resourcePath, createFolder, resourceData);
        parseEntityFromResponse(createdResource, CustomException.class);
    }

    /**
     * Creates the modify resource.
     *
     * @param createFolder the create folder
     * @param resourcePath the resource path
     * @param resourceData the resource data
     * @param overwrite the overwrite
     * @param resourceIdentifier the resource identifier
     * @throws CustomException the custom exception
     */
    public void createModifyResource(final boolean createFolder, final String resourcePath, final Folder resourceData, final Boolean overwrite, final String resourceIdentifier)
        throws CustomException {
        final ClientResponse<String> createdResource =
            resourceProxy.createModifyFolderWithIdentifierProvided(authorizationInfo, resourcePath, createFolder, overwrite, resourceIdentifier, resourceData);
        parseEntityFromResponse(createdResource, CustomException.class);
    }

    /**
     * Modify resource.
     *
     * @param resourcePath the resource path
     * @param patchItem the patch item
     * @throws CustomException the custom exception
     */
    public void modifyResource(final String resourcePath, final PatchItem patchItem) throws CustomException {
        final ClientResponse<String> modifiedResource = resourceProxy.modifyFolder(authorizationInfo, resourcePath, patchItem, "PATCH");
        parseEntityFromResponse(modifiedResource, CustomException.class);
    }

    /**
     * View all repository resources.
     *
     * @param searchString the search string
     * @param folderUri the folder uri
     * @param recursive the recursive
     * @param type the type
     * @param accessType the access type
     * @param showHiddenItems the show hidden items
     * @param sortBy the sort by
     * @param limit the limit
     * @param offset the offset
     * @param forceTotalCount the force total count
     * @return the uk.co.techblue.jasperclient.dto. resource
     * @throws CustomException the custom exception
     */
    public Resources viewAllRepositoryResources(final String searchString, final String folderUri, final boolean recursive, final String type,
        final String accessType,
        final boolean showHiddenItems, final String sortBy, final int limit, final int offset, final boolean forceTotalCount) throws CustomException {

        final ClientResponse<Resources> resources =
            resourceProxy.viewAllRepositoryResources(authorizationInfo, searchString, folderUri, recursive, type, accessType, showHiddenItems, sortBy, limit, offset,
                forceTotalCount);
        return parseEntityFromResponse(resources, CustomException.class);
    }

}
