package com.julian.rpncalc;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class OperationTest {

    @Test
    public void testCalculate() throws CalculatorException {
        Random r = new Random();
        double firstOperand = r.nextDouble();
        double secondOperand = r.nextDouble();
        assertEquals(secondOperand + firstOperand, Operation.ADDITION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand - firstOperand, Operation.SUBTRACTION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand * firstOperand, Operation.MULTIPLICATION.calculate(firstOperand, secondOperand), 0);
        assertEquals(secondOperand / firstOperand, Operation.DIVISION.calculate(firstOperand, secondOperand), 0);
    }

    @Test(expected = CalculatorException.class)
    public void testDivideByZero() throws CalculatorException {
        Operation.DIVISION.calculate(0.0, 0.0);
    }
}
