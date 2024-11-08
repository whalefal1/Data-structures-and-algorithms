package String;

public class MarsCodeString1 {

    public static String solution(String s) {
        // 去除前导零
        s = s.replaceFirst("^0+(?!$)", "");

        // 分离整数和小数部分
        String[] parts = s.split("\\.");
        String integerPart = parts[0];
        String decimalPart = parts.length > 1 ? "." + parts[1] : "";

        // 格式化整数部分
        StringBuilder formattedIntegerPart = new StringBuilder();
        int count = 0;
        for (int i = integerPart.length() - 1; i >= 0; i--) {
            formattedIntegerPart.append(integerPart.charAt(i));
            count++;
            if (count % 3 == 0 && i != 0) {
                formattedIntegerPart.append(",");
            }
        }
        formattedIntegerPart.reverse();

        // 合并结果
        return formattedIntegerPart.toString() + decimalPart;
    }

    public static void main(String[] args) {
        System.out.println(solution("1294512.12412").equals("1,294,512.12412"));
        System.out.println(solution("0000123456789.99").equals("123,456,789.99"));
        System.out.println(solution("987654321").equals("987,654,321"));
    }
}
