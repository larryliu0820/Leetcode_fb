import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 10/24/17.
 * 325. Maximum Size Subarray Sum Equals k
 */
public class p325 {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int[] sum = new int[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            sum[i+1] = sum[i] + nums[i];
            if (sum[i+1] == k) maxLen = Math.max(maxLen, i+1);
            else if (map.containsKey(sum[i+1]-k)) {
                maxLen = Math.max(i-map.get(sum[i+1]-k), maxLen);
            }
            map.putIfAbsent(sum[i+1], i);

        }
        return maxLen;
    }

    public static void main(String[] args) {
        p325 sol = new p325();
        sol.maxSubArrayLen(new int[]{1, -1, 5, -2, 3}, 3);
    }
}
