import java.util.*;

/**
 * Created by mengwliu on 10/28/17
 * 380. Insert Delete GetRandom O(1)
 */
public class p380 {
    Map<Integer, Integer> loc;
    List<Integer> nums;
    Random rand;
    /** Initialize your data structure here. */
    public p380() {
        loc = new HashMap<>();
        nums = new ArrayList<>();
        rand = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (loc.containsKey(val)) return false;
        loc.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!loc.containsKey(val)) return false;
        int index = loc.get(val);
        if (index != nums.size()-1) {
            nums.set(index, nums.get(nums.size()-1));
            loc.put(nums.get(index), index);
        }
        nums.remove(nums.size()-1);
        loc.remove(val);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}
