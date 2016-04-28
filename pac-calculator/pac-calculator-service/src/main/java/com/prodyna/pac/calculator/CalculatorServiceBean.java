package com.prodyna.pac.calculator;

import javax.ejb.Stateless;
import javax.ws.rs.ext.Provider;

@Stateless
@Provider
public class CalculatorServiceBean implements CalculatorService {

    @Override
    public int add(int a, int b) {
        int result = a + b;
        return result;
    }

}
