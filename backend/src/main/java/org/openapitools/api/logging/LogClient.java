package org.openapitools.api.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogClient {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";

    private Logger logger;

    public LogClient(Class<?> clazz) {
        logger = LoggerFactory.getLogger(clazz);
    }

    private String colorize(LogLevel level, String message) {
        String color;
        switch (level) {
            case INFO:
                color = ANSI_GREEN;
                break;
            case DEBUG:
                color = ANSI_CYAN;
                break;
            case WARN:
                color = ANSI_YELLOW;
                break;
            case ERROR:
                color = ANSI_RED;
                break;
            default:
                color = ANSI_RESET;
        }
        return color + message + ANSI_RESET;
    }

    public void info(String message) {
        logger.info(colorize(LogLevel.INFO, message));
    }

    public void debug(String message) {
        logger.debug(colorize(LogLevel.DEBUG, message));
    }

    public void warn(String message) {
        logger.warn(colorize(LogLevel.WARN, message));
    }

    public void error(String message) {
        logger.error(colorize(LogLevel.ERROR, message));
    }

    public enum LogLevel {
        INFO, DEBUG, WARN, ERROR
    }
}
