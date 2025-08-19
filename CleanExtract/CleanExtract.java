public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();

        for (String part : parts) {
            part = part.trim();
            int firstDot = part.indexOf('.');
            int lastDot = part.lastIndexOf('.');

            if (firstDot != -1 && lastDot != -1 && lastDot > firstDot) {
                String extracted = part.substring(firstDot + 1, lastDot).trim();
                if (!extracted.isEmpty()) {
                    if (result.length() > 0) {
                        result.append(" ");
                    }
                    result.append(extracted);
                }
            }
        }

        // Si aucun extrait trouvé, on renvoie la phrase nettoyée
        if (result.length() == 0) {
            String cleaned = s.replace("|", " ").replaceAll("\\s+", " ").trim();
            // Supprimer un point s'il est seul en début ou fin
            cleaned = cleaned.replaceAll("^\\.+", "").replaceAll("\\.+$", "").trim();
            return cleaned;
        }

        return result.toString();
    }
}
