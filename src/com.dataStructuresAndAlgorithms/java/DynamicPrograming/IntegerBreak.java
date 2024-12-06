package DynamicPrograming;

public class IntegerBreak {
    public int integerBreak(int n) {
        //dp数组初始化
        int[] dp = new int[n+1];
        //递推公式：如果可以分为为两个正整数相乘：max = i*(i-j)
        //如果是三个或三个以上正整数相乘： max = i*dp[i-j]
        /*
        2  1*1
        3  1*2
        4  2*2
        5  2*3
        6  3*3
        7  3*2*2= 3*4 = 3*dp[4]
        8  3*3*2 = 3*6 = 3*dp[5]
         */
        for(int i = 2 ; i <=n ; i++){
            int curMax = 0 ;
            for(int j = 1 ; j < i; j ++){
                curMax = Math.max(curMax,Math.max(j*(i-j),j*dp[i-j]));
            }
            dp[i] = curMax;
        }
        return dp[n];
    }
}
