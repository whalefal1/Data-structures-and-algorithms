package math;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class MarsCode12 {
    public static String solution(int A, int B) {
        // 计算剩余的奶酪量
        int remaining = B - A;

        // 将剩余的奶酪量转换为分数形式，分母为 B
        // 这里使用 BigDecimal 来避免精度问题
        BigDecimal remainingFraction = new BigDecimal(remaining).divide(new BigDecimal(B), 10, RoundingMode.HALF_UP);


        return remaining + "/" + B;
    }

    public static void main(String[] args) {
        System.out.println(solution(2, 7).equals("5/7"));
        System.out.println(solution(1, 3).equals("2/3"));
        System.out.println(solution(3, 5).equals("2/5"));
    }
}
