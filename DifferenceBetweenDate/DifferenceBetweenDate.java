import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DifferenceBetweenDate {

    public static Duration durationBetweenTime(LocalTime localTime1, LocalTime localTime2) {
        if (localTime1 == null || localTime2 == null) return null;
        Duration d = Duration.between(localTime1, localTime2);
        return d.isNegative() ? d.negated() : d;
    }

    public static Period periodBetweenDate(LocalDate date1, LocalDate date2) {
        if (date1 == null || date2 == null) return null;
        if (date1.isAfter(date2)) {
            return Period.between(date2, date1);
        } else {
            return Period.between(date1, date2);
        }
    }

    public static Long numberOfHoursBetweenDateTime(LocalDateTime dateTime1, LocalDateTime dateTime2) {
        if (dateTime1 == null || dateTime2 == null) return null;
        Duration d = Duration.between(dateTime1, dateTime2);
        return Math.abs(d.toHours());
    }
}