package com.prodyna.pac.web;

import com.prodyna.pac.calculator.CalculatorService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculator", value = "/calculator")
public class CalculatorServlet extends HttpServlet {

    @Inject
    private CalculatorService calculatorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {
        final PrintWriter writer = resp.getWriter();
        writer.write("Hello " + calculatorService.add(40, 2 ) );
        writer.close();
    }

}
