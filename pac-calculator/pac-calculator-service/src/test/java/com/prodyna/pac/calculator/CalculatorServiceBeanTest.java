package com.prodyna.pac.calculator;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

@RunWith(Arquillian.class)
public class CalculatorServiceBeanTest {

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addPackages( true, "com.prodyna.pac")
            .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Inject
    private CalculatorService calculatorService;

    @Inject
    private AddEventHelper eventHelper;

    @Test
    public void testCalculatorWithEvent() {
        int result = calculatorService.add( 10, 5 );
        Assert.assertEquals( 15, result );
        Assert.assertEquals( 1, eventHelper.getCount() );
    }

}
