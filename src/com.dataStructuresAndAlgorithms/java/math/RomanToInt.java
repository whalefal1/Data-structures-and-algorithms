package math;

public class RomanToInt {
    public int romanToInt(String s) {
        int sum = 0;
        int previous = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int num = getValue(s.charAt(i));
            sum = num <= previous? sum + previous : sum - previous;
            previous = num;
        }
        sum += previous;
        return sum;
    }

    private int getValue (char str) {
        switch (str) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}
