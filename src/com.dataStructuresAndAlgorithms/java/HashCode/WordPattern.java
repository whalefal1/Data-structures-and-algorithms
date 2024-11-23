package HashCode;

import java.util.ArrayList;
import java.util.List;

public class WordPattern {
    //给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
    //
    //这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
    //
    //
    //
    //示例1:
    //
    //输入: pattern = "abba", s = "dog cat cat dog"
    //输出: true
    //示例 2:
    //
    //输入:pattern = "abba", s = "dog cat cat fish"
    //输出: false
    //示例 3:
    //
    //输入: pattern = "aaaa", s = "dog cat cat dog"
    //输出: false

    public boolean wordPattern(String pattern, String s) {
        String[] split = s.split(" ");
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            ls.add(split[i]);
        }

        if(pattern.length() != ls.size()) return false;
        for (int i = 0; i < ls.size(); i++) {
            if(pattern.indexOf(pattern.charAt(i)) != ls.indexOf(ls.get(i))){
                return false;
            }

        }
        return true;
    }
}
