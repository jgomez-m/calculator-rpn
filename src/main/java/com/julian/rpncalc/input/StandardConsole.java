package com.julian.rpncalc.input;

import java.util.Scanner;

public class StandardConsole implements InputStreamI {
    private static StandardConsole instance;
    private Scanner scanner;

    public String getNextStream() {
        return scanner.nextLine();
    }

    public static InputStreamI getInstance() {
        return instance == null ? new StandardConsole() : instance;
    }

    private StandardConsole(){
        scanner = new Scanner(System.in);
    }
}
