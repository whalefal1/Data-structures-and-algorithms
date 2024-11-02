package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class Rotate {

    public void rotate(int[] nums, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            queue.offer(queue.poll());
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.poll();
        }
    }
}
