import java.util.*;

/**
 * Created by mengwliu on 10/26/17.
 * 15. 3Sum
 */
public class p015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            List<List<Integer>> twoSums = twoSum(nums, i+1, nums.length-1, -nums[i]);
            for (List<Integer> l: twoSums) l.add(nums[i]);
            res.addAll(twoSums);
            while (i < nums.length - 2 && nums[i] == nums[i+1]) i++;
        }

        return res;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        List<List<Integer>> res = new LinkedList<>();
        int oldVal;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                List<Integer> temp = new LinkedList<>();
                temp.add(nums[start]);
                temp.add(nums[end]);
                res.add(temp);
                oldVal = nums[start];
                while (start < end && nums[start] == oldVal) start++;
                oldVal = nums[end];
                while (start < end && nums[end] == oldVal) end--;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return res;
    }

}
