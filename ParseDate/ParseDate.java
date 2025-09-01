import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
        String[] parts = stringDate.split(", ");
        if (parts.length != 3) {
            return null;
        }

        String hoursPart = parts[0].trim();
        String minutesPart = parts[1].trim();
        String secondsPart = parts[2].trim();

        int hours;
        int minutes;
        int seconds;

        try {
            String[] hoursSplit = hoursPart.split(" ");
            if (hoursSplit.length != 3 || !hoursSplit[1].equals("heures")) {
                return null;
            }
            hours = Integer.parseInt(hoursSplit[0]);
            if (hoursSplit[2].equals("du soir")) {
                if (hours < 12) {
                    hours += 12;
                }
            } else if (!hoursSplit[2].equals("du matin")) {
                return null;
            }

            String[] minutesSplit = minutesPart.split(" ");
            if (minutesSplit.length != 3 || !minutesSplit[1].equals("minutes")) {
                return null;
            }
            minutes = Integer.parseInt(minutesSplit[0]);

            String[] secondsSplit = secondsPart.split(" ");
            if (secondsSplit.length != 3 || !secondsSplit[1].equals("secondes")) {
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