package String;

import java.util.HashMap;
import java.util.Map;

public class RomeToInt {

    Map<Character, Integer> symbolValues = new HashMap<Character, Integer>() {{
        put('I', 1);
        put('V', 5);
        put('X', 10);
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};


    public int romanToInt(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        for (int i = 0; i < n; i++) {

        }
    }
}
