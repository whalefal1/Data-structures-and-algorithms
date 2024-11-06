package math;

public class MarsCode1 {

    public static int solution(int n) {
        // write code here
       int count = 0;
       while(n > 1){
           if(n % 2 == 1){
                count+= (n-1)/2;
                n = (n-1)/2 + 1;
           }else {
               count += n/2;
               n = n/2;
           }
       }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(solution(7) == 6);
        System.out.println(solution(14) == 13);
        System.out.println(solution(1) == 0);
    }
}
