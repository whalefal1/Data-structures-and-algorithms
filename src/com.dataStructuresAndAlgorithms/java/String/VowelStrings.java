package String;

public class VowelStrings {

    public int[] vowelStrings(String[] words, int[][] queries) {
        int length = words.length;
        int[] prefix = new int[length + 1];
        for (int i = 0; i < length; i++) {
            if (isAEIOU(words[i])) {
                prefix[i + 1] = prefix[i] + 1;
            } else {
                prefix[i + 1] = prefix[i];
            }
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            result[i] = prefix[right + 1] - prefix[left];
        }
        return result;
    }
    //判断字符串是元音开头结尾
    public boolean isAEIOU(String str){
        char first = str.charAt(0);
        char last = str.charAt(str.length() - 1);
        return (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') &&
                (last == 'a' || last == 'e' || last == 'i' || last == 'o' || last == 'u');
    }
}
