package stack;

import java.util.Stack;

public class EvalRPN {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if(tokens[i] != "+"&&tokens[i]!="-"&&tokens[i]!="*"&&tokens[i]!="/"){
                stack.push(tokens[i]);
            }else{
                Integer x = Integer.valueOf(stack.pop());
                Integer y = Integer.valueOf(stack.pop());
                switch (tokens[i]){
                    case "*":stack.push(x*y+""); break;
                    case "/":stack.push(y/x+""); break;
                    case "+":stack.push(x+y+"");break;
                    case "-":stack.push(y-x+"");break;
                    default: continue;
                }
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {

        String[] s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        int i = evalRPN(s);
        System.out.println(i);
    }
}
