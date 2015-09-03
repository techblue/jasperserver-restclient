/*******************************************************************************
 * Copyright 2013, Barbon. All Rights Reserved. 
 * No part of this content may be used without Barbon's express consent.
 ******************************************************************************/
package uk.co.techblue.jasperclient.service;

import uk.co.techblue.jasperclient.client.Resource;
import uk.co.techblue.jasperclient.client.Service;
import uk.co.techblue.jasperclient.dto.Credentials;
import uk.co.techblue.jasperclient.utility.Util;

/**
 * AbstractService.java
 * 
 * @param <RT> the generic type
 * @author <a href="mailto:dishant.anand@techblue.co.uk">Dishant Anand</a>
 */
public abstract class AbstractService<RT extends Resource> extends Service<RT> {

    /** The authorization info. */
    protected String authorizationInfo;

    /**
     * Instantiates a new abstract service.
     * 
     * @param restBaseUri the rest base uri
     * @param login the login
     */
    public AbstractService(final String restBaseUri,final Credentials login) {
        super(restBaseUri);
        authorizationInfo = Util.getAuthorizationInformation(login);
    }

}
