package String;

public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        String s = "asc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }
}
