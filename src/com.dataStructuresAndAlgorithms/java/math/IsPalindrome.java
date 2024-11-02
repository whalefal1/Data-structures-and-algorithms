package math;

public class IsPalindrome {
    public boolean isPalindrome(int x) {
        //10
        //x  1     a 0   num 0
        //x  0     a 1   num 1
        //x  0     a 1   num 120+1
        if(x<0) return false;
        int origin = x;
        int a = 0;
        int num = 0;
        while(x>0){
            a = x % 10 ;
            x = x / 10 ;
            num = a + num*10;
        }
        System.out.println(num);
        if(origin == num || x==0) {return true;}
        else {return false;}
    }

    public static void main(String[] args) {
        int x = 10;
        IsPalindrome isPalindrome = new IsPalindrome();
        isPalindrome.isPalindrome(x);
    }
}
