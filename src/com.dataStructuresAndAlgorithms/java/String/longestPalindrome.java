package String;

import java.util.Stack;

/**
 * 最长回文子串
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * babad bab
 * cbbd bb
 * @author 李朋逊
 * @date 2023/10/20
 */
public class longestPalindrome {
    public String solution(String s){
        Stack stack = new Stack();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(!stack.peek().equals(chars[i])){
                stack.push(chars[i]);
            }

        }
        return null;
    }
}
