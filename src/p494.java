import java.util.HashMap;
import java.util.Map;

/**
 * Created by Larry Liu on 10/26/2017.
 * 494. Target Sum
 */
public class p494 {
    public int findTargetSumWays(int[] nums, int S) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        map.put(-nums[0], map.getOrDefault(-nums[0], 0) + 1);
        for (int i = 1; i < nums.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int key : map.keySet()) {
                int num = map.get(key);
                temp.put(key+nums[i], temp.getOrDefault(key+nums[i], 0) + num);
                temp.put(key-nums[i], temp.getOrDefault(key-nums[i], 0) + num);
            }
            map = temp;
        }
        return map.getOrDefault(S, 0);
    }

    public static void main(String[] args) {
        p494 sol = new p494();
        sol.findTargetSumWays(new int[]{1,1,1,1,1}, 3);
    }
}
