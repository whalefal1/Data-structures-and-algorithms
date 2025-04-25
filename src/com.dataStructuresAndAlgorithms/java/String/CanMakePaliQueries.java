package String;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CanMakePaliQueries {

    public static void main(String[] args) {

        String s = "abcda";

        int[][] queries = {{0,3,2}};

        CanMakePaliQueries canMakePaliQueries = new CanMakePaliQueries();
        List<Boolean> result = canMakePaliQueries.canMakePaliQueries(s, queries);
        for (Boolean b:result){
            System.out.println(b);
        }

    }

    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        if(s.equals(null) || queries == null) return null;

        List<Boolean> result = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];
            int replace = query[2];
            String substring = s.substring(start, end+1);
            boolean b = ifPali(substring, replace);
            result.add(b);

        }
        return result;
    }

    //判断一个字符串替换n个字母后是否可以回文
    public boolean ifPali(String s,int n){
        int length = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        //对所有字符进行计数
        for (Character c:s.toCharArray()){
            if(map.containsKey(c)){
                map.remove(c);
            }else{
                map.put(c,1);
            }
        }
        int size = map.size();
        return (size <= n) || size / 2 <= n;
    }
}
