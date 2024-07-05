package com.log.formatting;

import java.time.format.DateTimeFormatter;

public interface LogConstants {
    DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss");
    int LEVEL_WIDTH = 8;
}
