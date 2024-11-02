package Arrays;

public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int num =0;
        for (int i = 0; i < nums.length -1; i++) {
                if(nums[i] == k)
                    num ++;
                else sum+=nums[i];
            for (int j = i+1; j < nums.length; j++) {
                sum+=nums[j];
                if(sum == k){
                    num++;
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,1};
        int k = 2;
        SubarraySum subarraySum = new SubarraySum();
        int i = subarraySum.subarraySum(nums, k);
        System.out.println(i);

    }
}
