package String;

public class ReverseVowels {
    public String reverseVowels(String s) {
        char[] string = s.toCharArray();
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            while(left < string.length && !isVowel(string[left])){
                left ++;
            }
            while(right > 0 && !isVowel(string[right])){
                right--;
            }
            if(left < right){
                char temp = string[left];
                string[left] = string[right];
                string[right] = temp;
                left ++;
                right --;
            }

        }
        return new String(string);
    }
    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }
}
