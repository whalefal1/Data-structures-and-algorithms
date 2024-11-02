package Arrays;

import java.util.ArrayList;
import java.util.List;

public class getSumInGroup {


    public static int solution(int[] numbers) {
        // Please write your code here
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            List<Integer> node = getSon(num);
            list.add(node);
        }
        int result = 0;
        // 统计符合条件的组合数量
        for (List<Integer> combination : list) {
            int sum = 0;
            for (int num : combination) {
                sum += num;
            }
            if (sum % 2 == 0) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(new int[]{123, 456, 789}) == 14);
        System.out.println(solution(new int[]{123456789}) == 4);
        System.out.println(solution(new int[]{14329, 7568}) == 10);
    }


    public static List<Integer> getSon(int number){
        List<Integer> list = new ArrayList<>();
        while (number > 0) {
            list.add(number % 10);
            number = number / 10;
        }
        return list;
    }

}
