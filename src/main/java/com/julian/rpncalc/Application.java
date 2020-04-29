package com.julian.rpncalc;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;

public class Application {
    static String command;
    static boolean newCommand = false;

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Enter your expression, or 'q' to exit the application");

        boolean keepRunning = true;
        while (keepRunning) {
            Scanner sc = new Scanner(System.in);
            String inputString = sc.nextLine();
            if ("q".equals(inputString)) {
                System.exit(0);
            } else {
                try {
                    calculator.eval(inputString);
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }

                DecimalFormat fmt = new DecimalFormat("0.####");
                Double lastValue = calculator.getLastValue();
                System.out.println(fmt.format(lastValue));
            }
        }
    }
}