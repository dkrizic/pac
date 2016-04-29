package com.prodyna.pac.calculator;

import org.slf4j.Logger;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

@MessageDriven(/* mappedName="jms/queue/DemoQueue", */ activationConfig =  {
    @ActivationConfigProperty(propertyName = "acknowledgeMode",
        propertyValue = "Auto-acknowledge"),
    @ActivationConfigProperty(propertyName = "destinationType",
        propertyValue = "javax.jms.Queue"),
    @ActivationConfigProperty(propertyName = "destination",
        propertyValue = "jms/queue/DemoQueue")
})
public class QueueHelper implements MessageListener {

    @Inject
    private Logger log;

    
    @Override
    public void onMessage(Message message) {
        if( message instanceof MapMessage) {
            MapMessage mm = (MapMessage) message;
            try {
                log.error("Received " + mm.getInt("result") );
            } catch (JMSException e) {
                log.error( e.toString() );
            }
        }
    }
}
