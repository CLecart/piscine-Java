// java
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

public class ParseDate {

    public static LocalDateTime parseIsoFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        return LocalDateTime.parse(stringDate);
    }

    public static LocalDate parseFullTextFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) {
            return null;
        }
        String[] parts = stringDate.split(" ");
        if (parts.length != 4) {
            return null;
        }
        String dayStr = parts[1];
        String monthStr = parts[2];
        String yearStr = parts[3];

        int day;
        int month;
        int year;

        try {
            day = Integer.parseInt(dayStr);
            year = Integer.parseInt(yearStr);
        } catch (NumberFormatException e) {
            return null;
        }

        switch (monthStr.toLowerCase()) {
            case "janvier":
                month = 1;
                break;
            case "février":
                month = 2;
                break;
            case "mars":
                month = 3;
                break;
            case "avril":
                month = 4;
                break;
            case "mai":
                month = 5;
                break;
            case "juin":
                month = 6;
                break;
            case "juillet":
                month = 7;
                break;
            case "août":
                month = 8;
                break;
            case "septembre":
                month = 9;
                break;
            case "octobre":
                month = 10;
                break;
            case "novembre":
                month = 11;
                break;
            case "décembre":
                month = 12;
                break;
            default:
                return null;
        }

        try {
            return LocalDate.of(year, month, day);
        } catch (Exception e) {
            return null;
        }
    }

    public static LocalTime parseTimeFormat(String stringDate) {
        if (stringDate == null || stringDate.isEmpty()) {
            return null;
        }

        // Split hours from the rest (hours part is before the first comma)
        String[] parts = stringDate.split(",\\s*", 2);
        if (parts.length < 1) {
            return null;
        }

        String hoursPart = parts[0].trim();
        String rest = parts.length == 2 ? parts[1].trim() : "";

        int hours;
        int minutes;
        int seconds;

        try {
            // hoursPart expected like "09 heures du soir"
            String[] hoursSplit = hoursPart.split(" ", 3);
            if (hoursSplit.length != 3 || !hoursSplit[1].equals("heures")) {
                return null;
            }
            hours = Integer.parseInt(hoursSplit[0]);

            String suffix = hoursSplit[2].trim();
            if (suffix.equals("du soir")) {
                if (hours < 12) hours += 12;
            } else if (suffix.equals("du matin")) {
                if (hours == 12) hours = 0;
            } else {
                return null;
            }

            // rest expected like "07 minutes et 23 secondes" or "07 minutes, 23 secondes"
            // normalize " et " to ", " then split
            String normalized = rest.replaceAll("\\s+et\\s+", ", ");
            String[] msParts = normalized.split(",\\s*");
            if (msParts.length != 2) {
                return null;
            }

            String minutesPart = msParts[0].trim();
            String secondsPart = msParts[1].trim();

            String[] minutesSplit = minutesPart.split(" ");
            if (minutesSplit.length < 2 || !minutesSplit[1].startsWith("minute")) {
                return null;
            }
            minutes = Integer.parseInt(minutesSplit[0]);

            String[] secondsSplit = secondsPart.split(" ");
            if (secondsSplit.length < 2 || !secondsSplit[1].startsWith("second")) {
                return null;
            }
            seconds = Integer.parseInt(secondsSplit[0]);

        } catch (NumberFormatException e) {
            return null;
        }

        try {
            return LocalTime.of(hours, minutes, seconds);
        } catch (Exception e) {
            return null;
        }
    }

}