package Backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if(digits.length() == 0){
            return combinations;
        }
        //使用map作为号码与字母的映射
        Map<Character,String> phoneMap = new HashMap<>();
        phoneMap.put('2',"abc");
        phoneMap.put('3',"def");
        phoneMap.put('4',"ghi");
        phoneMap.put('5',"jkl");
        phoneMap.put('6',"mno");
        phoneMap.put('7',"pqrs");
        phoneMap.put('8',"tuv");
        phoneMap.put('9',"wxyz");
        backTracing(combinations,phoneMap,digits,0,new StringBuilder());
        return combinations;
    }

    //注意局部变量定义：List<String> 存储结果，Map<Character，String>存储号码与字母的映射
    //String digits，数字号码字符串，用于判断字母长度
    //StringBuilder，可变长字符串，用于存储字母号码
    //int index 字母号码长度
    private void backTracing(List<String> combinations,Map<Character,String> phoneMap,String digits,int index,StringBuilder stringBuilder) {
        //递归结束条件：字母长度==数字长度时，跳出递归
        if(index == digits.length()){
            combinations.add(stringBuilder.toString());
            //递归返回值
            return;
        }
        //获取当前号码
        char digit = digits.charAt(index);
        //获取当前号码的字母映射表
        String s = phoneMap.get(digit);
        int length = s.length();
        //遍历字母映射表
        for (int i = 0; i < length; i++) {
            //将当前遍历到的字母添加
            stringBuilder.append(s.charAt(i));
            //下一次递归：index+1即可
            backTracing(combinations,phoneMap,digits,index+1,stringBuilder);
            //注意：递归跳出之后，删除这个字母节点
            stringBuilder.deleteCharAt(index);
        }

    }



}
