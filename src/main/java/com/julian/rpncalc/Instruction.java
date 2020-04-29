package com.julian.rpncalc;

public class Instruction {
    private Operation operation;
    private Double value;

    public Instruction(Operation operation, Double value) {
        this.operation = operation;
        this.value = value;
    }
}
