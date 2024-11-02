package Arrays;

/*
长度最小子数组
 */
public class MinSubArray {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0;
        int result = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while(sum >= s){
                int p = right - left + 1;
                result = result > p ? p:result;
                sum -= nums[left++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
