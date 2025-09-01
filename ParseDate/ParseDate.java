import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        Pattern p = Pattern.compile(
                "^\\s*(\\d{1,2})\\s+heures\\s+(du soir|du matin)\\s*,\\s*(\\d{1,2})\\s+minutes\\s+et\\s+(\\d{1,2})\\s+secondes\\s*$",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
        );
        Matcher m = p.matcher(stringDate);
        if (!m.matches()) return null;

        try {
            int hours = Integer.parseInt(m.group(1));
            String suffix = m.group(2).toLowerCase(Locale.ROOT);
            int minutes = Integer.parseInt(m.group(3));
            int seconds = Integer.parseInt(m.group(4));

            if ("du soir".equals(suffix)) {
                if (hours < 12) hours += 12;
            } else { // du matin
                if (hours == 12) hours = 0;
            }

            return LocalTime.of(hours, minutes, seconds);
        } catch (Exception e) {
            return null;
        }
    }
}