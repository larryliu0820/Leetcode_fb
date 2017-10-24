import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 10/21/17
 * 1. Two Sum
 */
public class p001 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i]) && map.get(target-nums[i]) != i) {
                res = new int[]{i, map.get(target-nums[i])};
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}
