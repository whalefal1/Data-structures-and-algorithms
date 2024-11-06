package String;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        StringBuffer sgood = new StringBuffer();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                sgood.append(Character.toLowerCase(ch));
            }
        }
        StringBuffer sgoodRev = new StringBuffer(sgood).reverse();
        return sgood.toString().equals(sgoodRev.toString());
    }
}
