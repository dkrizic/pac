package com.prodyna.pac.calculator;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;

public class QueueProducer {

    @Resource(mappedName="jms/queue/DemoQueue")
    @Produces @Demo
    private javax.jms.Queue queue;

}
