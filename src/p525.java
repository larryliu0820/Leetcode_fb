import java.util.HashMap;
import java.util.Map;

/**
 * Created by mengwliu on 10/28/17
 * 525. Contiguous Array
 */
public class p525 {
    public int findMaxLength(int[] nums) {
        int[] sum = new int[nums.length+1];
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i-1] == 0) sum[i] = sum[i-1] - 1;
            else if(nums[i-1] == 1) sum[i] = sum[i-1] + 1;
            map.putIfAbsent(sum[i], i);
            max = Math.max(max, i-map.get(sum[i]));
        }
        return max;
    }

    public int findMaxLength2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> temp = new HashMap<>();
            for (int key: map.keySet()) {
                int index = map.get(key);
                int newKey = nums[i] == 0?(key-1):(key+1);
                if (temp.containsKey(newKey))
                    temp.put(newKey, Math.min(temp.get(newKey), index));
            }
            temp.putIfAbsent(nums[i] == 0? -1:1, i);
            max = Math.max(max, i - temp.getOrDefault(0, i+1) + 1);
            map = temp;

        }
        return max;
    }
}
