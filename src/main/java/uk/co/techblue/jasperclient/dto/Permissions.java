/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import java.util.ArrayList;
import java.util.Collection;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Permissions.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@JsonRootName("permissions")
public class Permissions extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -1752614242440474389L;

    /** The permissions. */
    @JsonProperty("permission")
    private Collection<Permission> permissions = new ArrayList<Permission>();

    /**
     * Gets the permissions.
     * 
     * @return the permissions
     */
    public Collection<Permission> getPermissions() {
        return permissions;
    }

    /**
     * Sets the permissions.
     * 
     * @param permissions the new permissions
     */
    public void setPermissions(Collection<Permission> permissions) {
        this.permissions = permissions;
    }

}
