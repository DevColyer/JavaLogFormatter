package com.log.formatting;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleLogFormatter extends Formatter implements LogConstants {

    @Override
    public String format(LogRecord record) {
        String resetColor = "\u001B[0m";
        String logColour = switch (record.getLevel().getName()) {
            //case "SEVERE" -> "\u001B[0;91m"; // red
            case "SEVERE" -> "\u001B[1;91m"; // bold red
            case "WARNING", "INFO" -> "\u001B[0;93m"; //  yellow
            case "CONFIG" -> "\u001B[0;96m"; // cyan
            case "FINE", "FINER", "FINEST" -> "\u001B[0;97m"; // white
            default -> "\u001B[0;37m"; // default
        };

        String level = String.format("%-" + LEVEL_WIDTH + "s", record.getLevel());

        String logMessage = "\u001B[0;37m" +
                LocalDateTime.now().format(DATE_TIME_FORMATTER) +
                " " +
                logColour +
                level +
                " | " +
                record.getSourceClassName() +
                ": " +
                record.getMessage() +
                resetColor +
                "\n";

        return logMessage;
    }
}
