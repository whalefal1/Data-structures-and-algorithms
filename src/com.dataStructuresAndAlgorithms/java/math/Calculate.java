package math;

import java.util.Deque;
import java.util.LinkedList;

public class Calculate {

    public int calculate(String s) {
        Deque<Integer> queue = new LinkedList<>();

        int sign = 1;
        queue.push(sign);
        int i = 0 ;
        int n  = s.length();

        int ret = 0;
        while(i < n){
            char c = s.charAt(i);
            switch (c){
                case ' ': i ++; break;
                case '+': sign = queue.peek();  i ++;break;
                case '-':sign = -queue.peek(); i++;break;
                case '(': queue.push(sign); i++;break;
                case ')':queue.pop();i++;break;
                default:
                    long num = 0;
                    while (i < n && Character.isDigit(s.charAt(i))) {
                        num = num * 10 + s.charAt(i) - '0';
                        i++;
                    }
                    ret += sign * num;
            }
        }
        return ret;
    }
}
