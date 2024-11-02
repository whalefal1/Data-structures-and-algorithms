package String;

import java.awt.*;

public class DNA {
    public static int solution(String dna1, String dna2) {
        int x = Math.abs(dna1.length()-dna2.length());
        int length = dna2.length();
        char[] charArray1 = dna1.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        int sub = 0;
        for (int i = 0; i < charArray1.length; ++i) {
            char c = charArray1[i];
            stringBuffer.append(c);
            String string = stringBuffer.toString();
            if(!dna2.contains(string)){
                length = length - string.length() + 1;
                dna2 = dna2.replaceFirst(string.substring(0,string.length()-1),"");
                stringBuffer = new StringBuffer();
            }else{
                sub ++;
            }
        }
        if(!stringBuffer.equals("")){
            String s = stringBuffer.toString();
            length = length -  s.length()  + 1;
        }
        return length + x  ;
    }
    public static void main(String[] args) {
        //  You can add more test cases here
        System.out.println(solution("AGCTTAGC", "AGCTAGCT") == 2);
        System.out.println(solution("AGCCGAGC", "GCTAGCT") == 4);
        System.out.println(solution("AGT","AGCT") == 1);
        System.out.println(
               " asdlkfj;lsakdjf"
        );
    }
}
