package Arrays;

public class SumOfEncryptedInt {

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            int max = 0;
            //获取每一位十进制数
            int base = 0;
            while (x != 0) {
                int y = x % 10;
                max = Math.max(max, y);
                x /= 10;
                base = base * 10 + 1;
            }
            sum+= max*base;
        }
        return sum;
    }
}
