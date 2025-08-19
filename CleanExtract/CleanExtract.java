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

            // On garde seulement les segments avec contenu entre deux points
            if (firstDot != -1 && lastDot != -1 && lastDot > firstDot + 1) {
                String extracted = part.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                }
            }
        }

        // Si aucun extrait trouvé → on nettoie toute la phrase
        if (result.length() == 0) {
            String cleaned = s.replace("|", " ").replaceAll("\\s+", " ").trim();
            cleaned = cleaned.replaceAll("^\\.+", "").replaceAll("\\.+$", "").trim();
            return cleaned;
        }

        return result.toString();
    }
}
