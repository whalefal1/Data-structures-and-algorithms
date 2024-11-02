package String;

public class LengthOfLongestSubstring {
    public int solution(String s){
        //字符串长度
        int m = s.length();
        if (m==0){
            return 0;
        }
        int length = 0;
        //定义max记录最长子串的长度
        int max = Integer.MIN_VALUE;
        //将字符串转换为字符数组便于遍历
        char[] character = s.toCharArray();
        //定义一个可变字符串用于连接字符，生成子串
        StringBuilder string = new StringBuilder("");
        //遍历字符串
        for (int i = 0; i < m; i++) {
            //将第i个字符转换为string类型便于比较
            String c = Character.toString(character[i]);
            //将可变字符串转换为字符串
            String str = string.toString();
            //若字符串中含有第i个字符
            if(str.contains(c)){
                //将重复的字符连接到可变字符串
                string.append(character[i]);
                //更新最长子串长度
                max = Math.max(max,length);
                //找到子串中重复字符的位置，因为字符在字符串中的位置按数组索引，所以要在删除的时候索引+1
                // abcabc    当遍历到第二个a时，length = 3 ， front = 0  string = abca       无重复字符的字符串长度为3
                int front = str.indexOf(character[i]);
                //更新length值，注意length表示的是字符串的长度，更新length时
                length = string.length() - front-1;
                string.delete(0,front+1);
            }else {
                length++;
                string.append(character[i]);
                max = Math.max(max,length);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "dvdf";
       LengthOfLongestSubstring substrings = new LengthOfLongestSubstring();
       int a = substrings.solution(s);
       System.out.println(a);
    }

}
