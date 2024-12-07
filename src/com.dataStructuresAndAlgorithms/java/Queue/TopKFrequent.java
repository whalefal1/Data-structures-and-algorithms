package Queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

    public class TopKFrequent {
        public int[] topKFrequent(int[] nums, int k) {
                //使用Map统计值与出现次数
            Map<Integer,Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                if(map.containsKey(nums[i])){
                    map.put(nums[i],map.get(nums[i])+1);
                }else{
                    map.put(nums[i],1);
                }
            }
            //通过PriorityQueue优先级队列构建小顶堆，初始化时构建排序
            PriorityQueue<Integer> queue= new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return map.get(o1) - map.get(o2);
                }
            });
            //将出现次数最多的前k个元素加入堆中
            for (Integer key : map.keySet()) {
                if (queue.size() < k) {
                    queue.add(key);
                } else if (map.get(key) > map.get(queue.peek())) {
                    queue.remove();
                    queue.add(key);
                }
            }
            //生成结果
             int[] res = new int[k];
            for (int i = 0; i < k; i++) {
                res[i] = queue.remove();
            }
            return res;
        }
    }
