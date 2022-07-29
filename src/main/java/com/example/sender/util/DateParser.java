package com.example.sender.util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

public class DateParser {
    public static final String zone = "Europe/Moscow";

    public static long fromLocalDateTime(LocalDateTime localDateTime, ZoneId zoneId) {
        return localDateTime
                .atZone(zoneId)
                .toInstant()
                .toEpochMilli();
    }
    public static LocalDateTime toLocalDateTime(Long value, ZoneId zoneId) {
        return Optional.ofNullable(value)
                .map(v -> Instant.ofEpochMilli(v).atZone(zoneId).toLocalDateTime())
                .orElse(null);
    }

    public static LocalDateTime toLocalDateTimeUTC(Long value) {
        return Optional.ofNullable(value)
                .map(v -> Instant.ofEpochMilli(v).atZone(ZoneId.of(zone)).toLocalDateTime())
                .orElse(null);
    }

    public static long toEpochMilli(LocalDateTime localDateTime) {
        return localDateTime
                .atZone(ZoneId.of(zone))
                .toInstant()
                .toEpochMilli();
    }
}
