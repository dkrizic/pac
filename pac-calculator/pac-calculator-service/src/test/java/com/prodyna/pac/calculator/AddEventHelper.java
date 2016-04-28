package com.prodyna.pac.calculator;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.inject.Inject;

@ApplicationScoped
public class AddEventHelper {

    int count = 0;

    @Inject private Logger log;

    public void onEvent( @Observes AddEvent addEvent ) {
        count++;
    }

    public int getCount() {
        log.info("Count++");
        return count;
    }
}
