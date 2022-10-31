import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DatetimeUtils {
    ZoneId zoneId = ZoneId.systemDefault();
    public static LocalDateTime now() {
        return LocalDateTime.now();
    }

    public static String asString(LocalDateTime localDateTime, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return localDateTime.format(df);
    }

    public static LocalDateTime asLocalDateTime(String dateTimeStr, String pattern) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
        return LocalDateTime.parse(dateTimeStr, df);
    }

    public static String convertPattern(String dateTimeStr, String fromPattern, String toPattern) {
        DateTimeFormatter fromDf = DateTimeFormatter.ofPattern(fromPattern);
        LocalDateTime localDateTime = LocalDateTime.parse(dateTimeStr, fromDf);
        DateTimeFormatter toDf = DateTimeFormatter.ofPattern(toPattern);
        return localDateTime.format(toDf);
    }
}
