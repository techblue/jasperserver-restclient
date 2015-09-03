/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * ResourceProperty.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class ResourceProperty extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 6483179577897281546L;

    /** The name. */
    @JsonProperty("name")
    private String name;

    /** The value. */
    @JsonProperty("value")
    private String value;

    /**
     * Gets the name.
     * 
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     * 
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the value.
     * 
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     * 
     * @param value the new value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
