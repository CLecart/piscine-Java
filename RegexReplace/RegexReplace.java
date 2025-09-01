import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null || s.isEmpty()) return s;
        return s.replaceAll("(?<=\\d)(cm|€)(?= |\\Z)", "");
    }

    public static String obfuscateEmail(String s) {
        if (s == null || s.isEmpty()) return s;

        Pattern emailPattern = Pattern.compile("([A-Za-z0-9._%+-]+)@([A-Za-z0-9.-]+\\.[A-Za-z]{2,})");
        Matcher m = emailPattern.matcher(s);
        StringBuffer out = new StringBuffer();

        while (m.find()) {
            String local = m.group(1);
            String domain = m.group(2);

            String obfLocal = obfuscateLocal(local);
            String obfDomain = obfuscateDomain(domain);

            m.appendReplacement(out, Matcher.quoteReplacement(obfLocal + "@" + obfDomain));
        }
        m.appendTail(out);

        return out.toString();
    }

    private static String obfuscateLocal(String local) {
        if (local.contains(".")) {
            int idx = local.indexOf('.');
            return local.substring(0, idx + 1) + repeat('*', local.length() - idx - 1);
        } else if (local.contains("-")) {
            int idx = local.indexOf('-');
            return local.substring(0, idx + 1) + repeat('*', local.length() - idx - 1);
        } else if (local.contains("_")) {
            int idx = local.indexOf('_');
            return local.substring(0, idx + 1) + repeat('*', local.length() - idx - 1);
        } else {
            int keep = Math.min(3, local.length());
            return local.substring(0, keep) + repeat('*', local.length() - keep);
        }
    }

    private static String obfuscateDomain(String domain) {
        String[] parts = domain.split("\\.");
        if (parts.length == 2) {
            parts[0] = repeat('*', parts[0].length());
            if (!parts[1].equals("com") && !parts[1].equals("net") && !parts[1].equals("org")) {
                parts[1] = repeat('*', parts[1].length());
            }
        } else if (parts.length == 3) {
            parts[0] = repeat('*', parts[0].length());
            parts[2] = repeat('*', parts[2].length());
        } else {
            for (int i = 0; i < parts.length; i++) {
                parts[i] = repeat('*', parts[i].length());
            }
        }
        return String.join(".", parts);
    }

    private static String repeat(char c, int n) {
        if (n <= 0) return "";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) sb.append(c);
        return sb.toString();