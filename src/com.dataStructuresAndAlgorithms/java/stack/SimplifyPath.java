package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class SimplifyPath {

    //给你一个字符串 path ，表示指向某一文件或目录的 Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为 更加简洁的规范路径。
    //
    //在 Unix 风格的文件系统中规则如下：
    //
    //一个点 '.' 表示当前目录本身。
    //此外，两个点 '..' 表示将目录切换到上一级（指向父目录）。
    //任意多个连续的斜杠（即，'//' 或 '///'）都被视为单个斜杠 '/'。
    //任何其他格式的点（例如，'...' 或 '....'）均被视为有效的文件/目录名称。
    //返回的 简化路径 必须遵循下述格式：
    //
    //始终以斜杠 '/' 开头。
    //两个目录名之间必须只有一个斜杠 '/' 。
    //最后一个目录名（如果存在）不能 以 '/' 结尾。
    //此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
    //返回简化后得到的 规范路径 。
    //
    //
    //
    //示例 1：
    //
    //输入：path = "/home/"
    //
    //输出："/home"
    //
    //解释：
    //
    //应删除尾随斜杠。
    //
    //示例 2：
    //
    //输入：path = "/home//foo/"
    //
    //输出："/home/foo"
    //
    //解释：
    //
    //多个连续的斜杠被单个斜杠替换。
    //
    //示例 3：
    //
    //输入：path = "/home/user/Documents/../Pictures"
    //
    //输出："/home/user/Pictures"
    //
    //解释：
    //
    //两个点 ".." 表示上一级目录（父目录）。
    //
    //示例 4：
    //
    //输入：path = "/../"
    //
    //输出："/"
    //
    //解释：
    //
    //不可能从根目录上升一级目录。
    //
    //示例 5：
    //
    //输入：path = "/.../a/../b/c/../d/./"
    //
    //输出："/.../b/d"
    //
    //解释：
    //
    //"..." 在这个问题中是一个合法的目录名。
    //
    //


    public static String simplifyPath(String path) {
            Stack<Character> stack = new Stack<>();
            stack.push('/');
            for (int i = 0; i < path.length(); i++) {
                char c = path.charAt(i);
                //如果是/
                if(c == '/') {
                    //如果是/代表一个目录结束需要处理
                    Character peek = stack.peek();
                    if(peek == '/'){
                        continue;
                    } else if(peek.equals('.')){
                        //如果为. 需要统计.个数
                        int x = 0;
                        while(!stack.isEmpty() && stack.peek() == '.'){
                            stack.pop();
                            x++;
                        }
                        if(x == 3) {
                            stack.push('.');
                            stack.push('.');
                            stack.push('.');
                        }
                        else if(x == 2){
                            stack.pop();
                            while(!stack.isEmpty()&&stack.peek()!='/'){
                                stack.pop();
                            }
                            if(!stack.isEmpty()){
                                stack.pop();
                            }
                        }else{
                            stack.pop();
                        }
                    }
                    stack.push('/');
                }
                //如果是字母或者.直接入栈
               else {
                 stack.push(c);
                }
            }
            if(stack.peek() == '/'){
                stack.pop();
            }
            StringBuilder stringBuilder = new StringBuilder();
            while(!stack.isEmpty()){
                stringBuilder.append(stack.pop());
            }
            return stringBuilder.reverse().toString();
    }


    public static  String simplifyPath1(String path) {
        //将字符串按/分隔，存在三种情况：字母 . . .  和空字符（因为存在//的情况）
        String[] names = path.split("/");
        //需要回溯曾经遍历过的元素（/abc/../->/），使用栈进行存储
        Deque<String> stack = new ArrayDeque<String>();
        for (String name : names) {
            //当为. . 时，需要回溯
            if ("..".equals(name)) {
                //此时. .还未入栈，直接删除..之前的一个目录路径
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (name.length() > 0 && !".".equals(name)) {
                //当不为..时即不需要处理，直接入栈
                stack.offerLast(name);
            }
        }
        StringBuffer ans = new StringBuffer();
        if (stack.isEmpty()) {
            //首元素为/
            ans.append('/');
        } else {
            //每次出栈一个元素就增加一个/
            while (!stack.isEmpty()) {
                ans.append('/');
                ans.append(stack.pollFirst());
            }
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        String s = "/../";
        String s1 = simplifyPath(s);
        System.out.println(s1);
    }
}
