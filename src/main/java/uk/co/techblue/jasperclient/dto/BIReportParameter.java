/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Class BIReportParameter.
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class BIReportParameter extends BaseDto {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -2014788490091940413L;

    /** The report parameter. */
    private Map<String, List<String>> reportParameter = new HashMap<String, List<String>>();

    /**
     * Gets the report parameter.
     * 
     * @return the report parameter
     */
    public Map<String, List<String>> getReportParameter() {
        return this.reportParameter;
    }

    /**
     * Sets the report parameter.
     * 
     * @param reportParameter the report parameter
     */
    public void setReportParameter(final Map<String, List<String>> reportParameter) {
        this.reportParameter = reportParameter;
    }

}
