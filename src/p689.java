/**
 * Created by Larry Liu on 10/29/2017.
 * 689. Maximum Sum of 3 Non-Overlapping Subarrays
 */
public class p689 {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length, maxSum = 0;
        int[] ans = new int[3];
        int[] sums = new int[n+1];
        for (int i = 1; i <= n; i++) sums[i] = sums[i-1] + nums[i-1];
        int[] posLeft = new int[n];

        for (int i = k, total = sums[k]-sums[0]; i < n; i++) {
            if (sums[i+1] - sums[i+1-k] > total) {
                posLeft[i] = i+1-k;
                total = sums[i+1] - sums[i+1-k];
            } else posLeft[i] = posLeft[i-1];
        }

        int[] posRight = new int[n];
        posRight[n-k] = n-k;
        for (int i = n - k - 1, total = sums[n] - sums[n-k]; i >= 0; i--) {
            if (sums[i+k] - sums[i] > total) {
                posRight[i] = i;
                total = sums[i+k] - sums[i];
            } else posRight[i] = posRight[i+1];
        }

        for (int i = k; i <= n-2*k; i++) {
            int l = posLeft[i-1], r = posRight[i+k];
            int total = (sums[i+k]-sums[i]+(sums[l+k]-sums[l]) + (sums[r+k]-sums[r]));
            if (total > maxSum) {
                maxSum = total;
                ans[0] = l; ans[1] = i; ans[2] = r;
            }
        }
        return ans;
    }
}
