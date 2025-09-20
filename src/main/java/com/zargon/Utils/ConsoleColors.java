package com.zargon.Utils;

public class ConsoleColors {
    // ANSI escape codes for text colors
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    /**
     * Prints a message to the console with the specified color.
     *
     * @param color The ANSI escape code string for the desired color (e.g., ConsoleColors.RED).
     * @param message The string message to be printed.
     */
    public static void printColored(String color, String message) {
        System.out.println(color + message + RESET);
    }
    /**
     * Prints a message to the console with the specified color.
     *
     * @param color The ANSI escape code string for the desired color (e.g., ConsoleColors.RED).
     * @param message The string message to be printed.
     */
    public static void printColoredInline(String color, String message) {
        System.out.print(color + message + RESET);
    }

}
