package Arrays;

import java.util.LinkedList;
import java.util.Queue;

public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length < k){
            return new int[0];
        }
        int[] result = new int[length - k +1];
        //引入单调队列
        Queue<Integer> queue = new LinkedList<>();
        //表示队列头元素的索引位置
        int num = 0;
        //初始化
        queue.add(Integer.MIN_VALUE);
        for (int i = 0; i < k; i++) {
            Integer peek = queue.peek();
            while(!queue.isEmpty() && nums[i] > peek){
                queue.poll();
                num=i;
            }
            queue.add(nums[i]);
        }

        result[0] = queue.peek();

        //移动窗口
        for (int i = k; i < length; i++) {
            //首先判断队列头元素是否被移除
            while(i-num >= k){
                //被移除
                queue.poll();
                num++;
            }
            int x = nums[i];
            //其次保证队列单调
            int s = queue.size();
            while(s > 0){
                Integer poll = queue.poll();
                if(poll < x){
                    num = i;
                }else{
                    queue.add(poll);
                }
            }
            queue.add(x);
            result[i-k+1] = queue.peek();
        }

        return  result;
    }

    public static void main(String[] args) {

            int[] nums = {1,3,1,2,0,5};
        int k = 3;
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        int[] ints = maxSlidingWindow.maxSlidingWindow(nums, k);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }
}
