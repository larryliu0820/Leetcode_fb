import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/28/2017.
 * 377. Combination Sum IV
 */
public class p377 {
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);

        Map<Integer, Integer> memo = new HashMap<>();
        return helper(nums, memo, target);
    }

    private int helper(int[] nums, Map<Integer, Integer> memo, int target) {

        if (!memo.containsKey(target)) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) count++;
                else if (nums[i] > target) break;
                else count += helper(nums, memo, target - nums[i]);
            }
            memo.put(target, count);
        }
        return memo.get(target);
    }

}
