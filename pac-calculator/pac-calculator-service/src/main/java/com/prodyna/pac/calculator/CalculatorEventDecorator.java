package com.prodyna.pac.calculator;

import org.slf4j.Logger;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Decorator
public abstract class CalculatorEventDecorator implements CalculatorService {

    @Inject
    private Logger log;

    @Inject
    Event<AddEvent> addEvent;

    @Inject
    @Delegate
    private CalculatorService delegate;

    @Override
    public int add(int a, int b) {
        log.info("Firing event");
        int result = delegate.add( a, b );
        addEvent.fire( new AddEvent( result ) );
        return result;
    }

}
