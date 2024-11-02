package Arrays;

/*
移除元素
 */
public class RemoveElement {
    public int solution(int val,int[] nums){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if(val != nums[fastIndex]) nums[slowIndex++] = nums[fastIndex];
        }return slowIndex;
    }
}
