package GreedyAlgorithm;


/**
 * 最大子数组的和
 *
 * @author 李朋逊
 * @date 2023/05/31
 */
public class MaxSubArray {

    public int solution1(int[] nums){
        if (nums.length == 1){
            return nums[0];
        }
        //定义结果，对最大的连续和进行记录，定义变量为int数据类型最小值，防止特殊情况
        int sum = Integer.MIN_VALUE;
        //定义连续和
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            //或取某一连续区间的连续和，因为连续和为正，对于以后的和都是增大的作用，所以只要count为正，count就会一直加
            count += nums[i];
            sum = Math.max(sum, count); // 取区间累计的最大值（相当于不断确定最大子序终止位置）
            if (count <= 0){
                count = 0; // 相当于重置最大子序起始位置，因为遇到负数一定是拉低总和
            }
        }
        return sum;
    }
}
