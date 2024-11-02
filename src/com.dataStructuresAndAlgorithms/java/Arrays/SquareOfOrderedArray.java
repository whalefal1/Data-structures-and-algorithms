package Arrays;

/*
有序数组平方排序
 */
public class SquareOfOrderedArray {
    public int[] solution(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int index = nums.length-1;
        int[] result = new int[nums.length];
        while(left<=right){
            if(nums[left]*nums[left] > nums[right]*nums[right]) {
                result[index--] = nums[left] * nums[left];
                left++;
            }
            else {
                result[index--] = nums[right]*nums[right];
                right--;
            }
        }return result;
    }
}
