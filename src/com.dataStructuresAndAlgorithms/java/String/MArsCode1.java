package String;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//问题描述
//在一场经典的德州扑克游戏中，有一种牌型叫做“葫芦”。“葫芦”由五张牌组成，其中包括三张相同牌面值的牌
//a 和另外两张相同牌面值的牌
//b。如果两个人同时拥有“葫芦”，我们会优先比较牌
//a 的大小，若牌
//a 相同则再比较牌
//b 的大小。
//在这个问题中，我们对“葫芦”增加了一个限制：组成“葫芦”的五张牌牌面值之和不能超过给定的最大值
//max。牌面值的大小规则为：A > K > Q > J > 10 > 9 > ... > 2，其中 A 的牌面值为1，K 为13，依此类推。
//给定一组牌，你需要找到符合规则的最大的“葫芦”组合，并输出其中三张相同的牌面和两张相同的牌面。如果找不到符合条件的“葫芦”，则输出 “0, 0”。
public class MArsCode1 {
    public static int[] solution(int n, int max, int[] array) {
        // 统计每种牌面值的出现次数
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int card : array) {
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        // 按牌面值从大到小排序
        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        sortedMap.putAll(countMap);

        // 尝试找到符合条件的“葫芦”组合
        int[] result = {0, 0};
        for (int a : sortedMap.keySet()) {
            if (countMap.get(a) >= 3) {
                for (int b : sortedMap.keySet()) {
                    if (a != b && countMap.get(b) >= 2) {
                        // 计算当前组合的牌面值之和
                        int sum = a * 3 + b * 2;
                        if (sum <= max) {
                            // 更新当前最大组合
                            result[0] = a;
                            result[1] = b;
                            return result; // 直接返回，因为已经按从大到小排序
                        }
                    }
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        // Add your test cases here

        System.out.println(java.util.Arrays.equals(solution(9, 34, new int[]{6, 6, 6, 8, 8, 8, 5, 5, 1}), new int[]{8, 5}));
        System.out.println(java.util.Arrays.equals(solution(9, 37, new int[]{9, 9, 9, 9, 6, 6, 6, 6, 13}), new int[]{6, 9}));
        System.out.println(java.util.Arrays.equals(solution(9, 40, new int[]{1, 11, 13, 12, 7, 8, 11, 5, 6}), new int[]{0, 0}));
        System.out.println(java.util.Arrays.equals(solution(31, 42, new int[]{3,3,11,12,12,2,13,5,13,1,13,8,8,1,8,13,12,9,2,11,3,5,8,11,1,11,1,5,4,2,5}), new int[]{1,13}));



    }
}
