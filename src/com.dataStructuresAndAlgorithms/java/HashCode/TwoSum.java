package HashCode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] toSum(int[] nums,int sum){
        //结果集
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //遍历数组元素
        for (int i = 0; i<nums.length;i++) {
            //获得map中寻找的key
            int temp = sum - nums[i];
            //若map中存在key，则把结果存入结果集
            if(map.containsKey(temp)){
                res[1] = i;
                res[0] = map.get(temp);
                //结束循环
                break;
            }
            //若map中不存在key，则把这个数组元素及下标存入map
            //注意不能先存入数组元素和下标，因为可能会存在两个相同的数组元素的和满足条件例：sum=6数组为{1,3,3}，则生成的结果集可能为{1,1}
            //map在此题中的作用仅仅是存放已经遍历的数组元素并判断数组中是否存在指定元素，所以遍历数组元素要先判断是否符合条件再存入map
            map.put(nums[i],i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,1,2,3,4,5,6,7,8,9};
        int sum = 5;
        TwoSum twoSum = new TwoSum();
        int[] res = twoSum.toSum(nums,sum);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
}
