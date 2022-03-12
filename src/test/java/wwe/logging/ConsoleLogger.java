package wwe.logging;

import org.apache.log4j.Logger;

public class ConsoleLogger extends Logger {

    public static final String CONSOLE_RESET = "\u001B[0m";
    public static final String CONSOLE_BLACK = "\u001B[30m";
    public static final String CONSOLE_RED = "\u001B[31m";
    public static final String CONSOLE_GREEN = "\u001B[32m";
    public static final String CONSOLE_YELLOW = "\u001B[33m";
    public static final String CONSOLE_BLUE = "\u001B[34m";
    public static final String CONSOLE_PURPLE = "\u001B[35m";
    public static final String CONSOLE_CYAN = "\u001B[36m";
    public static final String CONSOLE_WHITE = "\u001B[37m";

    public ConsoleLogger() {
        super("ConsoleLogger");
    }

    @Override
    public void debug(Object message) {
        this.println(message, CONSOLE_GREEN);
    }

    @Override
    public void info(Object message) {
        this.println(message);
    }

    @Override
    public void warn(Object message) {
        this.println(message, CONSOLE_YELLOW);
    }

    @Override
    public void error(Object message) {
        this.println(message, CONSOLE_RED);
    }

    @Override
    public void fatal(Object message) {
        this.println(message, CONSOLE_PURPLE);
    }

    public void println(Object message) {
        System.out.println(message);
    }

    public void println(Object message, String color) {
        System.out.println(color + message + CONSOLE_RESET);
    }
}
