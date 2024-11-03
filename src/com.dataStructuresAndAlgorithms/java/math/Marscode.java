package math;

public class Marscode {

    //完美整数
    //问题描述
    //一个整数如果由相同的数字构成，则称为完美整数。例如：
    //
    //1、11、333 是完美整数。
    //12、19、101 是不完美整数。
    //现在，你需要计算给定区间 [x, y] 中有多少个整数是完美整数。
    //
    //测试样例
    //样例1：
    //
    //输入：x = 1 ,y = 10
    //输出：9
    //
    //样例2：
    //
    //输入：x = 2 ,y = 22
    //输出：10
    public static int solution(int x, int y) {
        int count = 0;

        // 遍历区间 [x, y] 中的每一个整数
        for (int i = x; i <= y; i++) {
            // 检查当前整数是否为完美整数
            if (isPerfectNumber(i)) {
                count++;
            }
        }

        return count;
    }

    // 检查一个整数是否为完美整数
    private static boolean isPerfectNumber(int num) {
        // 将整数转换为字符串
        String numStr = String.valueOf(num);
        // 获取字符串的第一个字符
        char firstChar = numStr.charAt(0);

        // 检查字符串中的所有字符是否相同
        for (char c : numStr.toCharArray()) {
            if (c != firstChar) {
                return false;
            }
        }

        return true;
    }


    public static void main(String[] args) {
        // Add your test cases here

        System.out.println(solution(1, 10) == 9);
        System.out.println(solution(2, 22) == 10);
    }
}
