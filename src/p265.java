/**
 * Created by Larry Liu on 11/8/2017.
 * 265. Paint House II
 */
public class p265 {
    public int minCostII(int[][] costs) {
        if (costs == null || costs.length == 0) return 0;
        int n = costs.length, k = costs[0].length;
        int[] min = new int[]{-1, -1};
        for (int i = 0; i < n; i++) {
            int[] val = new int[2];
            int[] prevMin = min;
            for (int x = 0; x < 2; x++) {
                val[x] = min[x] < 0? 0: costs[i-1][min[x]];
            }
            min = new int[]{-1, -1};
            for (int j = 0; j < k; j++) {
                if (j != prevMin[0]) {
                    costs[i][j] += val[0];
                } else {
                    costs[i][j] += val[1];
                }
                if (min[0] < 0 || costs[i][j] < costs[i][min[0]]) {
                    min[1] = min[0];
                    min[0] = j;
                } else if (min[1] < 0 || costs[i][j] < costs[i][min[1]]) {
                    min[1] = j;
                }
            }
        }
        return costs[n-1][min[0]];
    }
}
