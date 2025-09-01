import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;
        try {
            DateTimeFormatter iso = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            return LocalDateTime.parse(stringDate, iso);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;
        try {
            DateTimeFormatter french = DateTimeFormatter.ofPattern("EEEE d MMMM uuuu", Locale.FRENCH);
            return LocalDate.parse(stringDate, french);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) return null;

        DateTimeFormatter soir = DateTimeFormatter.ofPattern(
                "H 'heures' 'du soir', m 'minutes' 'et' s 'secondes'",
                Locale.FRENCH
        );
        DateTimeFormatter matin = DateTimeFormatter.ofPattern(
                "H 'heures' 'du matin', m 'minutes' 'et' s 'secondes'",
                Locale.FRENCH
        );

        try {
            LocalTime t = LocalTime.parse(stringDate, soir);
            int h = t.getHour();
            if (h < 12) h += 12;
            return LocalTime.of(h, t.getMinute(), t.getSecond());
        } catch (Exception ignored) {}

        try {
            LocalTime t = LocalTime.parse(stringDate, matin);
            int h = t.getHour();
            if (h == 12) h = 0;
            return LocalTime.of(h, t.getMinute(), t.getSecond());
        } catch (Exception ignored) {}

        return null;
    }
}