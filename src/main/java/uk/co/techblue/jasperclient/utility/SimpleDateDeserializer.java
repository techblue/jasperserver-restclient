/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved.
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.utility;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * The Class SimpleDateDeserializer.
 *
 * @author <a href="mailto:dheeraj.arora@techblue.co.uk">Dheeraj Arora</a> Jan 17, 2014
 */
public class SimpleDateDeserializer extends JsonDeserializer<Date> {

    /*
     * (non-Javadoc)
     * 
     * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
     * org.codehaus.jackson.map.DeserializationContext)
     */
    @Override
    public Date deserialize(final JsonParser jsonparser, final DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException {
        final String dateString = jsonparser.getText();
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        final SimpleDateFormat simpleDateFormatWithT = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss");
        try {
            if (dateString.contains("T")) {
                return simpleDateFormatWithT.parse(dateString);
            } else {
                return simpleDateFormat.parse(dateString);
            }
        } catch (final ParseException pe) {
            throw new IOException("Error occurred while parsing date '" + dateString + "'", pe);
        }
    }
}
