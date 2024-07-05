package com.log.formatting;

import java.time.LocalDateTime;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class FileLogFormatter extends Formatter implements LogConstants {
    @Override
    public String format(LogRecord record) {
        String level = String.format("%-" + LEVEL_WIDTH + "s", record.getLevel());

        String logMessage = LocalDateTime.now().format(DATE_TIME_FORMATTER) +
                " " +
                level +
                " | " +
                record.getSourceClassName() +
                ": " +
                record.getMessage() +
                "\n";

        return logMessage;
    }
}
