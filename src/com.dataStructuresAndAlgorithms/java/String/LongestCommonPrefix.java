package String;

import java.util.Arrays;
///最长公共前缀
//使用字符串排序的方法——字符串排序是按照单个字符一次排序，即按照字符串前缀排序，因此只需比较首尾字符串的前缀即可
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < strs[0].length(); i++) {
            if(strs[0].charAt(i) == strs[strs.length-1].charAt(i)){
                stringBuffer.append(strs[0].charAt(i));
            }else{
                break;
            }
        }
        return stringBuffer.toString();
    }
}
