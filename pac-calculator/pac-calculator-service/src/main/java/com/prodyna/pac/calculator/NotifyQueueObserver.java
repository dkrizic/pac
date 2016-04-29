package com.prodyna.pac.calculator;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

public class NotifyQueueObserver {

    @Inject
    private JMSContext jmsContext;

    @Inject @Demo
    private Queue queue;

    public void onEvent( @Observes AddEvent addEvent ) {
        Map<String,Object> message = new HashMap<>();
        message.put("result", addEvent.getLastValue() );
        jmsContext.createProducer().send( queue, message );
    }

}
