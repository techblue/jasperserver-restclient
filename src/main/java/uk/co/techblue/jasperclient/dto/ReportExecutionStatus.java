/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * ReportExecutionStatus.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class ReportExecutionStatus extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 3415709344232925548L;

    /** The value. */
    @JsonProperty
    private String value;

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
