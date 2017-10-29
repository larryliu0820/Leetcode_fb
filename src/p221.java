import java.util.Stack;

/**
 * Created by Larry Liu on 10/26/2017.
 * 221. Maximal Square
 */
public class p221 {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] dp = new int[matrix.length+1][matrix[0].length+1];
        int max = 0;
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                if (matrix[i-1][j-1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j] * dp[i][j]);
            }
        }
        return max;
    }
}
