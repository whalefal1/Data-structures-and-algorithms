package String;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] s1 = s.split(" ");
        int i = s1.length - 1;
        String string = s1[i];
        return string.length();
    }
}
