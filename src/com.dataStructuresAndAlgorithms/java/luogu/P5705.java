package luogu;

import java.util.Scanner;

public class P5705 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for (int i = s.length()-1; i >= 0 ; i--) {
            System.out.println(s.charAt(i));
        }
        scanner.close();
    }
}
