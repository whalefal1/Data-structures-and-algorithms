package String;
//反转字符串中的单词
public class ReverseWords {
    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!s1[i].equals("")) {
                stringBuffer.append(s1[i]);
                stringBuffer.append(" ");
            }
        }
        return stringBuffer.toString().trim();
    }
}
