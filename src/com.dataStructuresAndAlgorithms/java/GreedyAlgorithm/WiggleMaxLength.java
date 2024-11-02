package GreedyAlgorithm;

/**
 * 摆动序列
 *
 * @author 李朋逊
 * @date 2023/05/29
 */
public class WiggleMaxLength {
    public int solution(int[] nums){
        /*特殊情况：1.数组为空，直接返回0；
        *                   2.数组只有一个元素：最小摆动序列就为1
        */
        if(nums.length<2){
            return nums.length;
        }
        //定义sum记录摆动个数
        int sum = 0;
        //定义摆动变量，因为判断摆动的情况只有大于0或小于0两种，所以选择boolean类型的变量，flag为true时代表上升摆动，flag为false时代表下降摆动
        Boolean flag = null;
        //遍历数组，注意：因为要比较i与i-1下标元素，所以i初始值为1
        for (int i = 1; i < nums.length; i++) {
            //如果两数相等，直接跳过
            if(nums[i] == nums[i-1])continue;
            //情况一：第i下标大于第i-1下标，说明为上升的摆动
            if(nums[i]>nums[i-1]){
                //如果flag不为空且flag为ture，则说明前一个摆动为上升摆动，此时为单调上升，需要跳过
                if(flag != null&&flag){
                    continue;
                }
                //上升摆动flag定义为true
                flag=true;
            }else {
                //情况二：第i下标小于第i-1下标，说明为下降的摆动
                //如果flag不为空且flag为false，则说明前一个摆动为下降摆动，此时为单调下降，需要跳过
                if(flag!=null&&flag){
                    continue;
                }
                //下降摆动flag定义为false
                flag = false;
            }
            //因为前面的判断语句中，不合理的情况都采用了continue，所以不合理情况都没有进行sum++，前面的判断语句都执行之后，说明不合理情况都被排除，所以可以直接进行sum++
            sum++;
        }
        return sum;
    }

    /*
                                              2-------2
                                           /
         1-----------1----------1

        i=2(1)    preDiff = 0      curDiff = 1    为一个摆动
        i=2(2)    preDiff = 1      curDiff = 0    不为摆动
      */
    public int solution2(int[] nums){
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        //开始默认有一个摆动：无论是上坡，下坡，还是平坡，都会有一次摆动
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负，则说明这是一个摆动
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                //若为摆动，将当前差值赋值给preDiff用于记录前一个差值
                preDiff = curDiff;
            }
        }
        return count;
    }
}
