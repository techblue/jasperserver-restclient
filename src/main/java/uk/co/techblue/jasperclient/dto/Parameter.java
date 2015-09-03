/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Parameter.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class Parameter extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6854975015016086259L;

    /** The parameter. */
    @JsonProperty("parameter")
    private String parameter;

    /**
     * Instantiates a new parameter.
     * 
     * @param parameter the parameter
     */
    public Parameter(String parameter) {
        this.parameter = parameter;
    }

    /**
     * Gets the parameter.
     * 
     * @return the parameter
     */
    public String getParameter() {
        return parameter;
    }

    /**
     * Sets the parameter.
     * 
     * @param parameter the new parameter
     */
    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

}
