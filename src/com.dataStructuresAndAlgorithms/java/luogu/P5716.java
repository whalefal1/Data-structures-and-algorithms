package luogu;

import java.util.Scanner;

public class P5716 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        if(month == 2){
            if((year%4 == 0 && year %100 !=0)||year%400 ==0) {
                //闰年
                System.out.println(29);
            }else{
                System.out.println(28);
            }
        }else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12){
            System.out.println(31);
        }else{
            System.out.println(30);
        }
        scanner.close();

    }
}
