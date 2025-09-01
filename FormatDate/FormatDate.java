import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class FormatDate {

    public static String formatToFullText(LocalDateTime dateTime) {
        if (dateTime == null) return null;
        DateTimeFormatter dayMonth = DateTimeFormatter.ofPattern("d MMMM", Locale.FRENCH);
        DateTimeFormatter timeFmt = DateTimeFormatter.ofPattern("H'h'mm'm' 'et' ss's'", Locale.FRENCH);
        String dm = dateTime.format(dayMonth);
        String time = dateTime.format(timeFmt);
        return "Le " + dm + " de l'an " + dateTime.getYear() + " à " + time;
    }

    public static String formatSimple(LocalDate date) {
        if (date == null) return null;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("MMMM d yy", Locale.ITALIAN);
        return date.format(f);
    }

    public static String formatIso(LocalTime time) {
        if (time == null) return null;
        DateTimeFormatter f = DateTimeFormatter.ofPattern("HH:mm:ss.");
        return time.format(f);
    }

}