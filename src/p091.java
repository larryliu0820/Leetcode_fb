/**
 * Created by mengwliu on 10/25/17.
 * 91. Decode Ways
 */
public class p091 {
    public int numDecodings(String s) {
        if (s.length() == 0 || s.charAt(0) == '0') return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            int num1 = Integer.parseInt(s.substring(i-1, i));
            int num2 = Integer.parseInt(s.substring(i-2, i));
            if (num1 == 0) {
                if (10 <= num2 && num2 <= 26) dp[i] = dp[i-2];
                else return 0;
            } else {
                if (10 <= num2 && num2 <= 26) dp[i] = dp[i - 1] + dp[i - 2];
                else dp[i] = dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
