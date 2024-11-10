package String;

public class MarscodeString2 {

    public static void main(String[] args) {
        System.out.println(solution("0.1", "1.1") == -1);
        System.out.println(solution("1.0.1", "1") == 1);
        System.out.println(solution("7.5.2.4", "7.5.3") == -1);
        System.out.println(solution("1.0", "1.0.0") == 0);
    }

    public static int solution(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int i = 0;
        while (i < v1.length || i < v2.length) {
            int num1 = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2 = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            i++;
        }
        return 0;
    }
}
