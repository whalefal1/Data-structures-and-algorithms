package String;

public class MarsCode {

    public static int solution(int a, int b) {
        //将b插入到a的合适位置，是结果最大
        String s = String.valueOf(a);
        int i = 0;
        while (i < s.length() && s.charAt(i) > b + '0') {
            i++;
        }
        return Integer.parseInt(s.substring(0, i) + b + s.substring(i));
    }

    public static void main(String[] args) {
        System.out.println(solution(76543, 4) == 765443);
        System.out.println(solution(1, 0) == 10);
        System.out.println(solution(44, 5) == 544);
        System.out.println(solution(666, 6) == 6666);
        System.out.println(solution(9, 15) == 915);
    }
}
