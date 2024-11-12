package String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Int2Rom {
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public String intToRoman(int num) {
       StringBuilder  stringBuilder = new StringBuilder("");
        for (int i = 0; i < values.length; i++) {
            int x = values[i];
            String symbol = symbols[i];
            while(num >= x){
                num -= x;
                stringBuilder.append(symbol);
            }
            if (num == 0) {
                break;
            }
        }
        return stringBuilder.toString();
    }

}
