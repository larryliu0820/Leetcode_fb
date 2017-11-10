/**
 * Created by mengwliu on 10/25/17.
 * 91. Decode Ways
 */
public class p091 {
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0: 1;
        for (int i = 1; i < s.length(); i++) {
            int first = Integer.parseInt(s.substring(i, i+1));
            int second = Integer.parseInt(s.substring(i-1, i));
            dp[i+1] = ways(first) * dp[i] + ways(second, first) * dp[i-1];
        }
        return dp[s.length()];
    }

    private int ways(int i) {
        if (i == 0) return 0;
        else return 1;
    }

    private int ways(int i, int j) {
        int num = i * 10 + j;
        if (num > 26 || num < 10) return 0;
        return 1;
    }
}
