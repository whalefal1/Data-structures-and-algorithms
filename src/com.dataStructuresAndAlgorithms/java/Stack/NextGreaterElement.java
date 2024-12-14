package Stack;

import java.util.*;

public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int n = nums1.length;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(nums1[i],i);
        }
        Deque<Integer> deque = new ArrayDeque<>();
        int[] res = new int[n];
        Arrays.fill(res,-1);
        for(int x:nums2){
            while(!deque.isEmpty() && x> deque.peek()){
                int y = deque.pop();
                if(map.containsKey(y)){
                    res[map.get(y)] = x;
                }
            }
            if(map.containsKey(x)){
                deque.push(x);
            }
        }
        return res;
    }
}
