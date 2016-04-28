package com.prodyna.pac.calculator.test;

import com.prodyna.pac.calculator.CalculatorService;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.jsonp.JsonProcessingFeature;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import java.net.URL;

@RunWith(Arquillian.class)
public class CalculatorServiceRESTTest {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        WebArchive war = ShrinkWrap.create(WebArchive.class, "test.war");
        war.addPackages( true, "com.prodyna.pac" );
        // war.addPackages( true, "com.fasterxml.jackson");
        System.out.println( war.toString( true ) );
        return war;
    }

    @ArquillianResource
    private URL url;

    @Test
    @RunAsClient
    public void calculateViaRest() {
        Assert.assertNotNull( url );
        CalculatorService calculatorService = createService( CalculatorService.class );
        int result = calculatorService.add( 17, 4 );
        Assert.assertEquals( 21, result );
    }

    protected Client createClient() {
        final Client client = ClientBuilder.newClient();
        client.register(JsonProcessingFeature.class); // needed for "normal"
        client.register(JacksonFeature.class);      // needed for dynamic pr
        return client;
    }

    protected WebTarget createWebTarget() {
        String fullPath = url.toString() + "rest";
        log.info("URL = " + fullPath );
        WebTarget target = createClient().target( fullPath );
        return target;
    }

    protected <C> C createService(Class<C> ifaceType) {
        return WebResourceFactory.newResource(ifaceType, createWebTarget());
    }

}
