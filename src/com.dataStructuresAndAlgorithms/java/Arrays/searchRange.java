package Arrays;

public class searchRange {
    public  static int[] solution(int[] nums,int target){
        if(nums.length==0||nums[0]>target||nums[nums.length-1]<target)
            return new int[]{-1,-1};
        int i = 0, j = nums.length-1;
        while(i<j) {
            if (nums[i] < target) {
                i++;
                continue;
            }
            if (nums[j] > target) {
                j--;
                continue;
            }
            break;
        }
        if (nums[i] != target||nums[j] != target)
            return new int[]{-1,-1};
          return new int[]{i,j};
    }

    public static void main(String[] args) {
        int[] a = {};
        int[] solution = solution(a, 0);
        for (int i = 0; i < solution.length; i++) {
            System.out.println(solution[i]);
        }

    }
}
