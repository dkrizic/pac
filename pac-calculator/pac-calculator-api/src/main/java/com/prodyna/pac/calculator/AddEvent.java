package com.prodyna.pac.calculator;

public class AddEvent {

    private int lastValue;

    public AddEvent(int lastValue) {
        this.lastValue = lastValue;
    }

    public int getLastValue() {
        return lastValue;
    }

}
