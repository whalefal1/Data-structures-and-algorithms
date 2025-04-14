package String;

import java.util.ArrayList;
import java.util.List;

public class FindLongestWord {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("ale");
        list.add("apple");
        list.add("monkey");
        list.add("plea");
        String abpcplea = findLongestWord("abpcplea", list);
        System.out.println(abpcplea);
    }

    public static String findLongestWord(String s, List<String> dictionary) {

        dictionary.sort((str1,str2)->{
            if(str1.length() == str2.length()) {
                return str1.compareTo(str2);
            } else {
                return str2.length() - str1.length();
            }
        });
        for (String string:dictionary){
            int length = string.length();
            int p = 0 ;
            int q = 0 ;
            while(q < length && p < s.length()){
                if(string.charAt(q) == s.charAt(p) ){
                    q++;
                }
                p++;
                if(p == q){
                    return string;
                }
            }
        }
        return null;
    }
}
