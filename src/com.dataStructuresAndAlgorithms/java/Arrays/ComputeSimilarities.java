package Arrays;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ComputeSimilarities {

    public List<String> computeSimilarities(int[][] docs) {

        List<String> resultList = new ArrayList<>();

        for (int i = 0; i < docs.length; i++) {
           int[] arr1 = docs[i];
            //arr数组转集合
            List<Integer> list1 = Arrays.stream(arr1).boxed().collect(Collectors.toList());
            for (int j = i+1; j < docs.length; j++) {
                int[] arr2 =  docs[j];
                List<Integer> list2 = Arrays.stream(arr2).boxed().collect(Collectors.toList());
                float similarity = similarity(list1, list2);
                if(similarity > 0 ){
                    String result = i + "," + j + ":" + similarity ;
                    resultList.add(result);
                }
            }
        }
        return resultList;
    }

    public float similarity(List<Integer> list1,List<Integer> list2){
        //交集
        List<Integer> intersection  = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());
        //并集
        List<Integer> listAll = list1.parallelStream().collect(Collectors.toList());
        List<Integer> listAll2 = list2.parallelStream().collect(Collectors.toList());
        listAll.addAll(listAll2);
        return intersection.size()/listAll.size();
    }
}
