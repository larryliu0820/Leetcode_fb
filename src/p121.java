/**
 * Created by mengwliu on 10/21/17
 * 121. Best Time to Buy and Sell Stock
 */
public class p121 {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }
}
