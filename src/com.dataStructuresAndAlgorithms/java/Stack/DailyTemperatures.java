package Stack;

import java.util.Deque;
import java.util.LinkedList;
/*
单调栈——一般用于一维数组中，要寻找任一个元素的右边或者左边第一个比自己大或者小的元素的位置。时间复杂度为O(n)
 */

public class DailyTemperatures {
    /*
    暴力排序
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        for(int i = 0;i<temperatures.length-1;i++){
            for(int j = i+1;j<temperatures.length;j++){
                if(temperatures[j]>temperatures[i]){
                    answer[i] = j - i;
                    break;
                }
            }
        }
        return answer;
    }
//73,74,75,71,69,72,76,73
/*
单调栈
栈中存放的是数组元素的下标
通过记录数组中已遍历的元素，用空间换时间，从而减小时间复杂度
 */
    public int [] solution(int[] temperatures) {
        //声明数组存放结果
        int[] answer = new int[temperatures.length];
        //声明栈
        Deque<Integer> stack = new LinkedList();
        //遍历数组中的元素栈顶元素
        for (int i = 0; i < temperatures.length; i++) {
            //若当前数组元素小于或等于栈顶元素，则说明当前数组元素一定比栈中其他元素所表示的数组元素的值小，因为从栈底到栈顶是单调递减的，直接将当前数组元素的下标注入栈中
            if (temperatures[i] <= temperatures[stack.peek()]) {
                stack.push(i);
            } else {
                //先判断是否为空，若非空则判断当前元素的值是否大于栈顶元素（数组元素的下标）所代表的数组元素的值
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                    //若当前数组元素大于，则将当前数组元素的下标与栈顶元素做差
                    //此时就找到答案数组中下标为栈顶元素的索引的值
                    answer[stack.peek()] = i - stack.peek();
                    //将得出结果的栈顶元素出栈，从而判断下一个栈元素
                    stack.pop();
                }
                //将当前数组元素的下标存入栈中
                stack.push(i);
            }
        }
        return answer;
    }
}
