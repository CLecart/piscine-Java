public class StringLength {
    public static int getStringLength(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.length() == 0) return 0;
        }
        return s.length();
    }
}
