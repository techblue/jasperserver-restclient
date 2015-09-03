/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonRootName;

/**
 * Resources.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
@JsonRootName("resources")
public class Resources {

    /** The resources. */
    @JsonProperty("resourceLookup")
    private List<Resource> resourceList;

    /**
     * Gets the resource list.
     * 
     * @return the resource list
     */
    public List<Resource> getResourceList() {
        return resourceList;
    }

    /**
     * Sets the resource list.
     * 
     * @param resourceList the new resource list
     */
    public void setResourceList(final List<Resource> resourceList) {
        this.resourceList = resourceList;
    }

}
