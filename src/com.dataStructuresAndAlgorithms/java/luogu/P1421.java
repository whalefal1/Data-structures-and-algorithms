package luogu;


import java.util.Scanner;

public class P1421 {
    public static void main(String[] args) {

        Scanner  scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        double x = a+b*0.1;
        System.out.println((int) (x/1.9));
        scanner.close();
    }

}
