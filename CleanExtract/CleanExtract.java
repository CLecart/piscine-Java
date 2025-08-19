public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            part = part.trim();
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            String extracted;
            if (firstDot != -1 && lastDot != -1 && lastDot > firstDot) {
                extracted = part.substring(firstDot + 1, lastDot).trim();
            } else {
                extracted = part;
            }

            if (!extracted.isEmpty()) {
                if (result.length() > 0) {
                    result.append(" ");
                }
                result.append(extracted);
            }
        }

        return result.toString();
    }
}
