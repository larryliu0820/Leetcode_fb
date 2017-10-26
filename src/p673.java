/**
 * Created by Larry Liu on 10/25/2017.
 * 673. Number of Longest Increasing Subsequence
 */
public class p673 {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        int res = 0;
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            len[i] = 1;
            count[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (len[i] == len[j] + 1) count[i] += count[j];
                    else if (len[i] < len[j] + 1) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if (maxLen == len[i]) res += count[i];
            else if (maxLen < len[i]) {
                maxLen = len[i];
                res = count[i];
            }
        }
        return res;
    }
}
