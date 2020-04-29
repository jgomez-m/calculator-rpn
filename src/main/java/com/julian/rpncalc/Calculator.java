package com.julian.rpncalc;

import java.util.Stack;

public class Calculator {
    private Stack<Double> valuesStack = new Stack<Double>();
    private Stack<Instruction> instructionsStack = new Stack<Instruction>();
    private int currentTokenIndex = 0;

    private Double tryParseDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return null;
        }
    }

    /**
     * Processes a RPN string token
     *
     * @param token RPN token
     * @throws CalculatorException
     */
    private void processToken(String token) throws CalculatorException {
        Double value = tryParseDouble(token);
        if (value == null) {
            processOperator(token);
        } else {
            // it's a digit
            valuesStack.push(Double.parseDouble(token));
            instructionsStack.push(null);
        }
    }

    /**
     * Executes an operation on the stack
     *
     * @param operatorString  RPN valid operator
     * @throws CalculatorException
     */
    private void processOperator(String operatorString) throws CalculatorException {

        if (valuesStack.isEmpty()) {
            throw new CalculatorException("empty stack");
        }

        // searching for the operator
        Operation operation = Operation.getEnum(operatorString);
        if (operation == null) {
            throw new CalculatorException("invalid operation");
        }

        // clear value stack and instructions stack
        if (operation == Operation.CLEAR) {
            clearStacks();
            return;
        }

        // Checking that there are enough operand for the operation
        if (operation.getOperandsNumber() > valuesStack.size()) {
            throwInvalidOperand(operatorString);
        }

        Double firstOperand = valuesStack.pop();
        Double secondOperand = (operation.getOperandsNumber() > 1) ? valuesStack.pop() : null;
        Double result = operation.calculate(firstOperand, secondOperand);

        if (result != null) {
            valuesStack.push(result);
        }

    }

    private void clearStacks() {
        valuesStack.clear();
        instructionsStack.clear();
    }

    private void throwInvalidOperand(String operator) throws CalculatorException {
        throw new CalculatorException(
                String.format("operator %s doesn't have enough parameters", operator, currentTokenIndex));
    }

    /**
     * Returns the values valuesStack
     */
    public Stack<Double> getValuesStack() {
        return valuesStack;
    }

    public Double getLastValue() {
        return valuesStack.peek();
    }

    /**
     * Helper method to return a specific item in the valuesStack
     *
     * @param index index of the element to return
     */
    public Double getStackItem(int index) {
        return valuesStack.get(index);
    }

     /**
     * Evals a RPN expression and pushes the result into the valuesStack
     *
     * @param input valid RPN expression
     * @throws CalculatorException
     */
    public void eval(String input) throws CalculatorException {
        if (input == null) {
            throw new CalculatorException("Input cannot be null.");
        }
        this.currentTokenIndex = 0;
        String[] result = input.split("\\s");
        for (String aResult : result) {
            this.currentTokenIndex++;
            processToken(aResult);
        }
    }
}
