package Stack;

/*
有效的括号
 */
import java.util.Stack;

public class isValid {
        public boolean isValid(String s) {
            /*
            ({[]}) true    ({[)]) false   右括号的顺序需要与左括号相同
            (){}[] true 考虑到左右括号出现的可能性相同，则需要将左右括号分开考虑
            因为右括号的判断涉及到了顺序问题，且与左括号的顺序一一对应，则当出现左括号时，可将对应的右括号放入栈中
            因为栈具有后进先出的特点，栈顶元素就是与最近的左括号相匹配的右括号，当出现右括号时，就可将栈顶的元素与之比较
            若相同则就可将栈顶的元素出栈，继续进行相同的判断
            若不相同则直接结束循环
            当方法结束时可通过判断栈是否为空来判断字符串是否符合条件，当栈为空则说明任一左括号都可找到与之对应的右括号并且顺序相同
            若不为空，则字符串不满足条件
        */
            //实例顺序栈，栈的容量要大于左括号数量
            Stack<Character> stack = new Stack();
            for (int i = 0; i < s.length(); i++) {
                //遍历字符串中的字符
                    char a = s.charAt(i);
                    //若为左括号，则将对应的右括号放入栈
                    if(a == '('){
                        stack.push(')');
                    }else if(a == '{'){
                        stack.push('}');
                    }else if(a == '['){
                        stack.push(']');
                    }else {
                        //当第一个括号为右括号时，直接返回false
                        if(stack.isEmpty()){
                            return false;
                        }
                        //若为右括号则与栈顶元素比较，相同则出栈
                        if( a == stack.peek()){
                            stack.pop();
                        }else {
                            return false;
                        }
                    }
            }
            //判断栈是否为空，true则字符串满足要求，false则字符串不满足要求
            return  stack.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "({[]})";
        String s2 = "([})]";
        String s3 = ")(";
        isValid p = new isValid();
        System.out.println(p.isValid(s1));
        System.out.println(p.isValid(s2));
        System.out.println(p.isValid(s3));
    }
}
