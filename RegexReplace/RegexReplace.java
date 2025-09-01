
public class RegexReplace {
    public static String removeUnits(String s) {
        if (s == null) return null;
        return s.replaceAll("\\s*(cm|€)\\b", "");
    }

    public static String obfuscateEmail(String s) {
        if (s == null) return null;
        return s.replaceAll("([a-zA-Z0-9._%+-])([a-zA-Z0-9._%+-]*)(@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})", "$1***$3");
    }
}
