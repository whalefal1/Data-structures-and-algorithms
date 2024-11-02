package String;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        GroupAnagrams groupAnagrams = new GroupAnagrams();
        List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list);
        }

    }


    public static boolean isRight(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            //判断str1中的每个字符是否在str2中
            if (str2.contains(String.valueOf(str1.charAt(i)))) {
                continue;
            } else if (!str2.contains(String.valueOf(str1.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public List<List<String>> groupAnagrams(String[] strs) {
//        List<List<String>> list = new ArrayList<>();
//        for(int i = 0; i < strs.length-1; i ++) {
//            List<String> node = new ArrayList<>();
//            if (!strs[i].equals("")) {
//                node.add(strs[i]);
//            }
//                for (int j = i + 1; j < strs.length; j++) {
//                    if(strs[j].equals("")) continue;
//                    if (isRight(strs[i], strs[j])) {
//                        node.add(strs[j]);
//                        strs[j] = "";
//                    }
//                }
//                list.add(node);
//            }
//        return list;
        Map<String, List<String>> strToListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strToListMap.computeIfAbsent(String.valueOf(chars), key -> new ArrayList<>()).add(str);
        }
        return strToListMap.values().stream().collect(Collectors.toList());

    }


}
