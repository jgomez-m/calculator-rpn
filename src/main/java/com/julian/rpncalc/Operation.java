package com.julian.rpncalc;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    ADDITION("+", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return secondOperand + firstOperand;
        }
    },

    SUBTRACTION("-", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return secondOperand - firstOperand;
        }
    },

    MULTIPLICATION("*", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) {
            return secondOperand * firstOperand;
        }
    },

    DIVISION("/", 2) {
        public Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException {
            if (firstOperand == 0)
                throw new CalculatorException("Cannot divide by 0.");
            return secondOperand / firstOperand;
        }
    },

    CLEAR("clear", 0) {
        public Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException {
            throw new CalculatorException("Invalid operation");
        }
    };
    // using map for a constant lookup cost
    private static final Map<String, Operation> map = new HashMap<String, Operation>();

    static {
        for (Operation o : values()) {
            map.put(o.getSymbol(), o);
        }
    }

    private String symbol;
    private int operandsNumber;

    Operation(String symbol, int operandsNumber) {
        this.symbol = symbol;
        this.operandsNumber = operandsNumber;
    }

    public static Operation getEnum(String value) {
        return map.get(value);
    }

    public abstract Double calculate(Double firstOperand, Double secondOperand) throws CalculatorException;

    public String getSymbol() {
        return symbol;
    }

    public int getOperandsNumber() {
        return operandsNumber;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
