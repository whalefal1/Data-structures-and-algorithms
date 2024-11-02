package Arrays;

/**
 * 盛水最多的容器（11）
 *
 * @author 李朋逊
 * @date 2023/07/11
 */
public class MaxArea {
    public int solution(int[] height){
        int left = 0;
        int right = height.length - 1;
        int res = 0;
        while (left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, area);
            if (height[left] <= height[right]) {
                left++;
            }
            else {
                right--;
            }
        }
        return res;
    }
}
