package Arrays;

public class SmallestValue {

    public static void main(String[] args) {

        int n = 4;
        SmallestValue smallestValue = new SmallestValue();
        int result = smallestValue.smallestValue(n);
        System.out.println("The smallest value is: " + result);
    }

    public int smallestValue(int n) {
        int x = n;
        int sum = 0;
        while (true) {
            x = n;
            sum = 0;
            for (int i = 2; i * i <= x; i++) {
                while (x % i == 0) {
                    sum += i;
                    x /= i;
                }
            }
            if (x > 1) { // 最后还剩一个质数
                sum += x;
            }
            if (sum == n) { // 没变
                return sum;
            }
            n = sum;
        }
    }
}
