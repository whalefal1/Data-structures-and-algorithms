package luogu;

import java.util.Scanner;

public class P1425 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        if(b > d){
            System.out.println(c- a -1);
            System.out.print(d - b +60);
        }else{
            System.out.println(c-a);
            System.out.print(d-b);
        }
    }
}
