/**
 * Created by mengwliu on 10/29/17
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class p714 {
    public int maxProfit(int[] prices, int fee) {
        int[] dp = new int[prices.length];
        for (int i = 1; i < prices.length; i++) {
            for (int j = 0; j < i; j++) {
                if (prices[i] - prices[j] <= 2) continue;
                int currProfit = prices[i] - prices[j] - fee + dp[j];
                if (currProfit > dp[i]) {
                    dp[i] = currProfit;
                }
            }
            if (dp[i] < dp[i-1]) {
                dp[i] = dp[i-1];
            }
        }
        return dp[prices.length-1];
    }

    public static void main(String[] args) {
        p714 sol = new p714();
        System.out.println(sol.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
