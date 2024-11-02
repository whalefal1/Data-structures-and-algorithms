package HashCode;

import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        //对数组进行排序，
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            //因为数组已经按照从小到大进行排序，如果第一个数是大于0，则其余的数都大于0
            if(nums[i]>0){
                return res;
            }
            /*去重操作
            注意：此时是num[i-1]而不能是num[i+1]
             例：-1     -1     -1    2    3
            因为数组已经进行过排序操作，所以如果存在相同的元素，就一定是处于相邻位置上的。
            判断若为num[i-1]。遍历到第一个-1的时候不会跳过，生成一个结果集{-1，-1，2}，遍历到第二个-1的时候，判断到已经遍历过一次相同的值，就可以直接continue，跳过此数
            判断若为num[i+1]。遍历到第一个-1的时候，会判断第而个-1，此时判断结果为true，直接continue，没有生成结果集{-1，-1，2}，失败
            */
            if(i>0&&nums[i] == nums[i-1]){
                continue;
            }
            /*
            获得结果集
            定义left，right指针，left指向num[i+1](i的下一位)，right指向num[num.length-1](数组最后的元素)
            指针的移动，若和大于0，说明right指向的元素数值太大，right右移，若和小于0，说明left指向的元素太小，left左移
            一个结果集{a,b,c}
            其中a为num[i]，已经完成了去重的操作，还要对b和c进行去重
             */
            int left = i+1;
            int right = nums.length-1;
            //循环结束条件
            while(right>left){
                int sum = nums[i] + nums[left] + nums[right];
                //若和大于0，right左移
                if(sum>0){
                    right--;
                }else
                    //若和小于0，left右移
                if (sum<0){
                    left--;
                }else{
                    //生成结果集
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                //对right和left进行去重
                //例：-1              -1                    -1                     2                               2                     3
                    //    i             left1                left2              right3                       right2            right1
                //当i指向第一个-1时，left指向第二个-1，right指向3，和大于0，right左移一位为2，和为0，先生成一个结果集{-1，-1，2}
                //此时还不满足left>=right的循环结束条件，left右移，right左移，此时有产生了一个结果集{-1，-1，2}，因为此结果集与上一个结果集相同，所以要对right和left指向的元素去重
                //注意：right的去重是right与right-1进行比较，left的去重是left与left+1进行比较
                    while (right > left && nums[right] == nums[right - 1]) right--;
                while (right > left && nums[left] == nums[left + 1]) left++;
                right--;
                left++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,0};
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(nums));
    }
}
