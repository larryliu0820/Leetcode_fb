import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 10/24/17.
 * 325. Maximum Size Subarray Sum Equals k
 */
public class p325 {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums.length == 0) return 0;
        int max = 0;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sum.length; i++) {
            if (i > 0) sum[i] = sum[i-1] + nums[i];
            if (sum[i] == k) max = Math.max(max, i+1);
            else if (map.containsKey(sum[i] - k)) max = Math.max(max, i - map.get(sum[i] - k));
            map.putIfAbsent(sum[i], i);
        }
        return max;
    }

    public static void main(String[] args) {
        p325 sol = new p325();
        sol.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
    }
}
