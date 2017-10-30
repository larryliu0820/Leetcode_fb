/**
 * Created by mengwliu on 10/29/17
 * 714. Best Time to Buy and Sell Stock with Transaction Fee
 */
public class p714 {
    public int maxProfit(int[] prices, int fee) {
        long T_i0 = 0, T_i1 = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            long T_i0_old = T_i0;
            T_i0 = Math.max(T_i0, T_i1+prices[i]-fee);
            T_i1 = Math.max(T_i1, T_i0_old-prices[i]);
        }
        return (int)T_i0;
    }

    public static void main(String[] args) {
        p714 sol = new p714();
        System.out.println(sol.maxProfit(new int[]{1,3,2,8,4,9}, 2));
    }
}
