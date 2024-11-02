package GreedyAlgorithm;

import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author 李朋逊
 * @date 2023/05/29
 */
public class FindContentChildren {
    public int solution(int[] g,int[] s){
        //对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);
        //child指针用于指向当前最小胃口的孩子
        int child = 0;
        //sum用于统计能够满足孩子的数量
        int sum = 0;
        //遍历饼干数组，当孩子数取得最大值(s.length-1)的时候，说明孩子们都能够满足，此时不需要继续遍历，结束循环，当饼干数取得最大值(s.length-1)的时候，说明饼干已经全部用于判断，此时可以结束循环
        for (int i = 0; i < s.length && child < g.length; i++) {
            //当饼干能够满足孩子的时候，child指针指向下一个胃口最小的孩子，统计数加1
            if(s[i] >= g[child]){
                child++;
                sum++;
            }
        }
        return sum;
    }
}
