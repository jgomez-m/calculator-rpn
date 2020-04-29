package com.julian.rpncalc;

import com.julian.rpncalc.input.InputStreamI;
import com.julian.rpncalc.input.StandardConsole;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Application {
    static String command;
    static boolean newCommand = false;

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        System.out.println("Enter your expression, or 'q' to exit the application");

        boolean keepRunning = true;
        while (keepRunning) {
            InputStreamI inputStream = StandardConsole.getInstance();
            String inputString = inputStream.getNextStream();
            if ("q".equals(inputString)) {
                keepRunning = false;
            } else {
                try {
                    calculator.eval(inputString);
                    DecimalFormat fmt = new DecimalFormat("0.####");
                    Double lastValue = calculator.getLastValue();
                    if(lastValue != null) {
                        System.out.println(fmt.format(lastValue));
                    }
                } catch (CalculatorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        System.out.println("Bye, bye!!");
        System.exit(0);
    }
}
