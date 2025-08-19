public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.trim().isEmpty()) {
            return "";
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();
        boolean hasExtracted = false;

        for (String part : parts) {
            part = part.trim();
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            if (firstDot != -1 && lastDot != -1 && lastDot > firstDot + 1) {
                String extracted = part.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                    hasExtracted = true;
                }
            }
        }

        return hasExtracted ? result.toString() : s.trim();
    }
}
