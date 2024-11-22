package HashCode;

public class Issomorphic {
    public static boolean isIsomorphic(String s, String t) {
        //判断对应位置的字符是否相同
        for(int i = 0; i < s.length(); i++){
            if(s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {


        String s = "foo";
        String t = "bar";
        boolean isomorphic = isIsomorphic(s, t);
        System.out.println(isomorphic);
    }
}
