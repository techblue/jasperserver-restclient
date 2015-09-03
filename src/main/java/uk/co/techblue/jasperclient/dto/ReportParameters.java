/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * ReportParameters.java
 * 
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public class ReportParameters {

    /** The report parameters. */
    @JsonProperty("reportParameter")
    private List<ReportParameter> reportParameters;

    /**
     * Gets the report parameters.
     * 
     * @return the report parameters
     */
    public List<ReportParameter> getReportParameters() {
        return reportParameters;
    }

    /**
     * Sets the report parameters.
     * 
     * @param reportParameters the new report parameters
     */
    public void setReportParameters(final List<ReportParameter> reportParameters) {
        this.reportParameters = reportParameters;
    }

}
