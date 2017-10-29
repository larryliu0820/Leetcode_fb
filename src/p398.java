import java.util.*;

/**
 * Created by Larry Liu on 10/26/2017.
 */
public class p398 {
    Map<Integer, List<Integer>> map;
    public p398(int[] nums) {
        map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indices = map.get(target);
        Random rand = new Random();

        return map.get(target).get(rand.nextInt(indices.size()));
    }
}
