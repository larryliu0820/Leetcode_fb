/**
 * Created by Larry Liu on 10/29/2017.
 * 123. Best Time to Buy and Sell Stock III
 */
public class p123 {
    public int maxProfit(int[] prices) {
        long[][] profit_i = new long[3][2];
        for (int k = 0; k < 3; k++) {
            profit_i[k][0] = 0;
            profit_i[k][1] = Integer.MIN_VALUE;
        }

        for (int price: prices) {
            for (int k = 2; k > 0; k--) {
                profit_i[k][0] = Math.max(profit_i[k][0], profit_i[k-1][1] + price);
                profit_i[k][1] = Math.max(profit_i[k][1], profit_i[k][0] - price);
            }
        }
        return (int)profit_i[2][0];
    }
}
