package Queue;

import java.util.Deque;
import java.util.LinkedList;
/*
滑动窗口的最大值——单调队列
 */
public class MaxSlidingWindow {

    private Deque<Integer> deque = new LinkedList<>();

    /*
    出队
    当滑动窗口滑动前的首元素刚好是单调队列的首元素时，若滑动窗口的移动，单调队列的首元素就要随滑动窗口的移动而改变
    此方法先判断滑动窗口要移除的元素是否与单调队列的首元素相同，若相同则单调队列的首元素出队，若不同，则说明单调队列的首元素比互动窗口要移除的元素还要靠后
    即单调队列已经将滑动窗口要移除的元素移除了，则单调队列保持不变
     */
        public void pop(int value){
            if(!deque.isEmpty() && deque.peek() == value){
                deque.pop();
            }
        }
/*
入队
单调队列保持单调递减，新加入的元素要与队列中的最后一个元素比较，若队列元素的值大，则将新元素添加到队列最后，若新元素大，则将队列最后一个元素出队，再将新元素入队，从而保持队列单调性
 例：队列：                     新元素：
 --------------------
 3    1                                         2
 --------------------
 若直接将新元素添加到队列，队列就变为：
 --------------------
 3    1     2
 --------------------
此时队列不具备单调性，从而无法得到队滑动窗口的最大值
 */
        public void add(int value){
            while (!deque.isEmpty() && value > deque.getLast()) {
                deque.removeLast();
            }
            deque.add(value);
        }
        /*
        获取队列首元素的值
        若非空则直接返回首元素的值，若空则返回Integer类型最小值。
         */

   public  int peek(){
            if(!deque.isEmpty()) {
                return deque.peek();
            }else {
                return Integer.MIN_VALUE;
            }

   }
/*
具体实现方法
 */
    public  int[] maxSlidingWindow(int[] nums,int k){
        //特殊情况判断
            if(nums.length == 1){
                return nums;
            }

            MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
            //数组长为nums.length，滑动窗口长为k，则需要一个长为num.length-k的数组来储存结果
            int[] result = new int[nums.length-k+1];
        //用于指向结果数组的下标
            int num = 0;
            //先将第一个滑动窗口存入单调队列
        for (int i = 0; i < k; i++) {
            maxSlidingWindow.add(nums[i]);
        }
        //获取第一的滑动窗口的最大值
        result[num++] = maxSlidingWindow.peek();
        for (int i = k; i < nums.length; i++) {
            //移动滑动窗口，先通过pop()方法将单调队列中的滑动窗口移除的元素出队
            maxSlidingWindow.pop(nums[i-k]);
            //将新元素入队
            maxSlidingWindow.add(nums[i]);
            //此时得到的单调队列的首元素即为当前滑动窗口的最大值
            result[num++] = maxSlidingWindow.peek();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums ={1,5,8,9,7,2,5,3};
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] res = maxSlidingWindow.maxSlidingWindow(nums,2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
