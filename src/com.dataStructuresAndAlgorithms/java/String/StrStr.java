package String;

public class StrStr {
    public static int strStr(String haystack, String needle) {
        if(haystack.contains(needle)){
            return haystack.indexOf(needle);
        }else
        return -1;
    }
}
