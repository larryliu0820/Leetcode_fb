/**
 * Created by Larry Liu on 10/27/2017.
 * 209. Minimum Size Subarray Sum
 */
public class p209 {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < sums.length; i++) {
            sums[i] = nums[i-1] + sums[i-1];
        }
        if (sums[sums.length-1] - sums[0] < s) return 0;
        int lo = 0, min = sums.length;
        for (int i = lo; i < sums.length; i++) {
            while (sums[i] - sums[lo] >= s) {
                min = Math.min(min, i-lo);
                lo++;
            }
        }
        return min;
    }
}
