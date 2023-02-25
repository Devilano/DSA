package Que3;

public class PatternMatching {
    public static boolean match(String string, String pattern) {
        int s = 0, p = 0, starIdx = -1, match = -1;
        while (s < string.length()) {
            if (p < pattern.length() && (pattern.charAt(p) == '#' || string.charAt(s) == pattern.charAt(p))) {
                s++;
                p++;
            } else if (p < pattern.length() && pattern.charAt(p) == '@') {
                match = s;
                while (p < pattern.length() && pattern.charAt(p) == '@') {
                    p++;
                }
                if (p == pattern.length()) {
                    return true;
                }
                starIdx = p;
            } else if (starIdx != -1) {
                p = starIdx + 1;
                match++;
                s = match;
            } else {
                return false;
            }
        }
        while (p < pattern.length() && pattern.charAt(p) == '@') {
            p++;
        }
        return p == pattern.length();
    }

    public static void main(String[] args) {
        String a = "tt";
        String pattern = "@";
        System.out.println(match(a, pattern)); // Output: true

        a = "ta";
        pattern = "t";
        System.out.println(match(a, pattern)); // Output: false

        a = "ta";
        pattern = "t#";
        System.out.println(match(a, pattern)); // Output: true
    }
}
