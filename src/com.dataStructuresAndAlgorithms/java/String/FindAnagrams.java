package String;

import java.util.ArrayList;
import java.util.List;

public class FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        //示例 1:
        //
        //输入: s = "cbaebabacd", p = "abc"
        //输出: [0,6]
        //解释:
        //起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        //起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
        // 示例 2:
        //
        //输入: s = "abab", p = "ab"
        //输出: [0,1,2]
        //解释:
        //起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        //起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        //起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
        //

        List<Integer> list = new ArrayList<>();
        int length = s.length();
        StringBuffer stringBuffer = new StringBuffer(p);
        for (int i = 0; i < length; i++) {
            String string = stringBuffer.toString();
            String s1 = String.valueOf(s.charAt(i));
            if(string.contains(s1)){
                //若s中字符在stringbuffer中，stringbuffer要删除对应字符
                int i1 = string.indexOf(s1);
                stringBuffer.deleteCharAt(i1);
                if(stringBuffer.isEmpty()){
                    list.add(i - p.length() +1);
                    stringBuffer = new StringBuffer(p);
                }
            }else{
                stringBuffer = new StringBuffer(p);
                String string1 = stringBuffer.toString();
                if(string1.contains(s1)){
                    int i1 = string1.indexOf(s1);
                    stringBuffer.deleteCharAt(i1);
                }
            }
        }

        return list;

    }

    public static void main(String[] args) {

        String s = "cbaebabacd";
        String p = "abc";
        FindAnagrams findAnagrams = new FindAnagrams();
        List<Integer> anagrams = findAnagrams.findAnagrams(s, p);
        for (Integer anagram : anagrams) {
            System.out.println(anagram);
        }
    }
}
