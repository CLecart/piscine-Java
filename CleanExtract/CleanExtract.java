public class CleanExtract {
    public static String extract(String s) {
        String[] subStrArr = s.split("\\|");
        StringBuilder result = new StringBuilder();
        for (String subStr : subStrArr) {
            subStr = subStr.trim();
            if (!subStr.isEmpty()) {
                String cleaned = clean(subStr);
                if (!cleaned.isEmpty()) {
                    result.append(cleaned).append(" ");
                }
            }


        }

        return result.toString().trim();
    }

    public static String clean(String s) {
        int firstDot = s.indexOf(".");
        int lastDot = s.lastIndexOf(".");
        if (firstDot == -1 || firstDot == lastDot) {
            return s.substring(firstDot + 1).trim();
        } else {
            return s.substring(firstDot + 1, lastDot).trim();
        }
    }
}