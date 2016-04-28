package com.prodyna.pac.calculator;

import org.slf4j.Logger;

import javax.enterprise.event.Observes;
import javax.inject.Inject;

public class AddEventLogger {

    @Inject
    private Logger log;

    public void logAddEvent( @Observes AddEvent addEvent ) {
        log.error("Last calculation " + addEvent.getLastValue() );
    }

}
