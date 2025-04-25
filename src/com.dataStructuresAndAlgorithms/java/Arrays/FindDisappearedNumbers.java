package Arrays;

import java.util.HashMap;
import java.util.List;

public class FindDisappearedNumbers {

    //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数字，并以数组的形式返回结果。
    public List<Integer> findDisappearedNumbers(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], 1);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!map.containsKey(i)) {
                map.put(i, 0);
            }
        }
        return map.keySet().stream().filter(key -> map.get(key) == 0).toList();
    }
}
