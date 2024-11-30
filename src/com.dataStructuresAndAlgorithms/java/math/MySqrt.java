package math;

public class MySqrt {
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        //x的算数平方根等于e的lnx次方的算数平方根等于e**1/2*lnx
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;
    }
}
