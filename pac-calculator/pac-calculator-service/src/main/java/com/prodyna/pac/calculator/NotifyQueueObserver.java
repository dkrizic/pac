package com.prodyna.pac.calculator;

import javax.enterprise.event.Observes;

public class NotifyQueueObserver {

    public void onEvent( @Observes AddEvent addEvent ) {
        // TODO: Write MapMessage to queue java:/jms/queue/DemoQueue
    }

}
