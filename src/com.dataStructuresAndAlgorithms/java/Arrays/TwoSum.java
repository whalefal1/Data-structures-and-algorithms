package Arrays;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0 ;
         int high = numbers.length;
         while(low < high){
             int sum = numbers[low] + numbers[high];
             if(sum == target){
                 return new int[]{low , high};
             }else if(sum > target){
                 high --;
             }else {
                 low ++;
             }
         }
         return new int[]{};
    }
}
