/**
 * Created by mengwliu on 10/22/17
 * 674. Longest Continuous Increasing Subsequence
 */
public class p674 {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int maxLen = 1;
        int lastStart = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i-1]) {
                maxLen = Math.max(maxLen, i - lastStart + 1);
            } else {
                lastStart = i;
            }
        }
        return maxLen;
    }
}
