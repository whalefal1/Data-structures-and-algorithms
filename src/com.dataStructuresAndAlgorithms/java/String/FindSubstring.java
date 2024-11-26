package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindSubstring {
    //困难题，嘿嘿，我来啦
    //输入：s = "barfoothefoobarman", words = ["foo","bar"]
    //输出：[0,9]
    //解释：因为 words.length == 2 同时 words[i].length == 3，连接的子字符串的长度必须为 6。
    //子串 "barfoo" 开始位置是 0。它是 words 中以 ["bar","foo"] 顺序排列的连接。
    //子串 "foobar" 开始位置是 9。它是 words 中以 ["foo","bar"] 顺序排列的连接。
    //输出顺序无关紧要。返回 [9,0] 也是可以的。
    public static List<Integer> findSubstring(String s, String[] words) {
            List<Integer> res = new ArrayList<Integer>();
            //m：单词个数 n：单词长度 ls: 字符串长度
            int m = words.length, n = words[0].length(), ls = s.length();

            //按照单词长度取模对字符串分组
            // 0 n 2n
            // 1 n+1 2n+1
            // 2 n+2 2n+2
            //共n组，这样在截取字符串时就可以按照单词长度进行截取。
            for (int i = 0; i < n; i++) {

                if (i + m * n > ls) {
                    break;
                }
                //用于统计字符串与单词数组的不同
                Map<String, Integer> differ = new HashMap<String, Integer>();
                //将字符串按单词长度切分，并加入map中，每多一个单词就+1
                for (int j = 0; j < m; j++) {
                    //截取一个单词长度的字符串加入map
                    String word = s.substring(i + j * n, i + (j + 1) * n);
                    differ.put(word, differ.getOrDefault(word, 0) + 1);
                }
                //遍历单词数组，如果map中已存在数量就-1
                for (String word : words) {
                    differ.put(word, differ.getOrDefault(word, 0) - 1);
                    //数量变为0的单词删除
                    if (differ.get(word) == 0) {
                        differ.remove(word);
                    }
                }

                //移动窗口，右边增加一个单词，左边减少一个单词，对应的单词数增删
                for (int start = i; start < ls - m * n + 1; start += n) {
                    if (start != i) {
                        //窗口右边增加单词
                        String word = s.substring(start + (m - 1) * n, start + m * n);
                        differ.put(word, differ.getOrDefault(word, 0) + 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                        //窗口左边减少单词
                        word = s.substring(start - n, start);
                        differ.put(word, differ.getOrDefault(word, 0) - 1);
                        if (differ.get(word) == 0) {
                            differ.remove(word);
                        }
                    }
                    //如果map成功清零，则该下标符合题意
                    if (differ.isEmpty()) {
                        res.add(start);
                    }
                }
            }
            return res;
        }
}
