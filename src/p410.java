/**
 * Created by Larry Liu on 11/1/2017.
 * 410. Split Array Largest Sum
 */
public class p410 {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        long lo = max, hi = sum;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (isValid(nums, m, mid)) hi = mid-1;
            else lo = mid+1;
        }
        return (int)lo;

    }

    private boolean isValid(int[] nums, int m, long limit) {
        int count = 0;
        long currSum = 0;
        for (int num : nums) {
            if (currSum >= limit) {
                count ++;
                currSum = 0;
                if (count > m) return false;
            }
            currSum += num;
        }
        return true;
    }
}
