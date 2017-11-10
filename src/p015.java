import java.util.*;

/**
 * Created by mengwliu on 10/26/17.
 * 15. 3Sum
 */
public class p015 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < nums.length-2; i++) {
            if (i == 0 || nums[i] != nums[i-1]) {
                int lo = i+1, hi = nums.length-1, sum = 0 - nums[i];
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == sum) {
                        res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
                        while (lo < hi && nums[lo] == nums[lo+1]) lo++;
                        while (lo < hi && nums[hi] == nums[hi-1]) hi--;
                        lo++; hi--;
                    } else if (nums[lo] + nums[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums) {
            map.putIfAbsent(i, 0);
            map.put(i,map.get(i)+1);
        }
        int[] arr = new int[nums.length];
        int k = 0;
        for (int key : map.keySet()) {
            for (int i = 0; i < map.get(key); i++) {
                arr[k++] = key;
            }
        }
        for ( int i = 0; i < arr.length-2; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = i+1; j < arr.length; j++) {
                if (set.contains(-(arr[i] + arr[j]))) {
                    List<Integer> list = Arrays.asList(
                            arr[i],
                            arr[j],
                            -(arr[i]+arr[j]));
                    res.add(list);
                } else set.add(arr[j]);
                while (j < arr.length-2 && arr[j] == arr[j+1]) j++;
            }
            while (i < arr.length-2 && arr[i] == arr[i+1]) i++;
        }
        return res;
    }
    public static void main(String[] args) {
        p015 sol = new p015();
        sol.threeSum2(new int[]{-2,0,1,1,2});
    }
}
