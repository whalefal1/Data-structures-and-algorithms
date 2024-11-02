package GreedyAlgorithm;

/**
 * 买卖股票的最佳时机
 *
 *  股票：   1             4                 6              2
 * 最大利润：6-1=5 = prices[2] - prices[0]  = (prices[2] - prices[1]) + (prices[1] - prices[0])
 * 即最大利润等于正利润的代数和
 * @author 李朋逊
 * @date 2023/05/31
 */
public class MaxProfit {
    public int solution(int[] prices){
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            //如果卖出-买入为正值，就说明能够获取利润
            int profit = prices[i] - prices[i-1];
            //当利润大于0
            if(profit>0){
                result += profit;
            }
        }
        return result;
    }
}
