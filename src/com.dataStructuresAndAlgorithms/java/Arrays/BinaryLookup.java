package Arrays;
/*
二分查找
 */

/*
解法1
 */
public class BinaryLookup {
    public int solution(int target,int[] nums){
        if(target<nums[0]||target>nums[nums.length-1]){
            return -1;
        }

        int x = Integer.MIN_VALUE;
        int left = 0;
        int right = nums.length;
        if(target<nums[0]||target>nums[right-1])return -1;
        while(left < right){
         int middle = (left + right) / 2;
         if(target > nums[middle]) left  = middle+1;
         else if(target < nums[middle]) right  = middle;
         else if(target == nums[middle]) return middle;
        }
        return -1;
    }
/*
解法2
 */
    public int solution1(int target,int[] nums){
        if(target<nums[0]||target>nums[nums.length-1]){
            return -1;
        }
        int left = 0;
        int right = nums.length-1;
        if(target<nums[0]||target>nums[right])return -1;
        while(left <= right){
            int middle = (left + right) / 2;
            if(target > nums[middle]) left  = middle+1;
            else if(target < nums[middle]) right  = middle-1;
            else if(target == nums[middle]) return middle;
        }
        return -1;
    }
}
