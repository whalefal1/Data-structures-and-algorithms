package math;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class test {

public static List<String> deleteRepeat(List<String> list){
   List<String> result = new ArrayList<>();
   HashMap<String,Integer> map = new HashMap<>();
   list.forEach(item->{
       if(!map.containsKey(item)){
           map.put(item,1);
           result.add(item);
       }
   });
   return result;
}



public static List<String> getDescThree(Map<String,Integer> map){

    ArrayList<String> result = new ArrayList<>();
    int max = Integer.MIN_VALUE;
    for(String key:map.keySet()){
        Integer i = map.get(key);
        if(i > max){
            max = i;
        }
    }
    return result;
}


public static  Map<String ,Integer> getNameNumber(List<String> list){
    Map<String,Integer> map = new HashMap<>();
    list.forEach(item->{
        if(!map.containsKey(item)){
            map.put(item,1);
        }else{
            map.put(item,map.get(item)+1);
        }
    });
    return map;
}

    public static  void splitNumber(List<String> list){
        List<String> number = new ArrayList<>();
        List<String> Char = new ArrayList<>();
        list.forEach(item->{
            if(item.matches("^[0-9]+$")){
                number.add(item);
            } else if (item.matches("^[a-z]|[A-Z]+$")) {
                Char.add(item);
            }
        });
        System.out.println("数字列表："+number.toString() + "字母列表："+Char.toString());
    }


    public static  Map<String,Double> countAver(Map<String,List<Integer>> map){
        Map<String,Double> result = new HashMap<>();
        for (String key:map.keySet()){
            List<Integer> integers = map.get(key);
            AtomicInteger sum = new AtomicInteger();
            integers.forEach(number->{
                sum.addAndGet(number);
            });
            Double score = Double.valueOf(sum.get())/3;
            result.put(key,score);
        }
        return result;
    }



    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        //["apple","banana","apple","orange","banana","grape","grape"]
        list.add("apple");
        list.add("banana");
        list.add("apple");
        list.add("orange");
        list.add("banana");
        list.add("grape");
        list.add("grape");
        List<String> strings = deleteRepeat(list);
        System.out.println(strings.toString());

    }


}
