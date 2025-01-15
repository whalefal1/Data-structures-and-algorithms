package luogu;

import java.util.Scanner;

public class P5711 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        if(year % 4 == 0 && year % 100 !=0){
            System.out.println(1);
            scanner.close();
        }
        else if(year % 400 == 0){
            System.out.println(1);
            scanner.close();
        }else{
        System.out.println(0);
        scanner.close();
        }

    }
}
