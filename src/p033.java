/**
 * Created by Larry Liu on 10/26/2017.
 * 33. Search in Rotated Sorted Array
 */
public class p033 {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1, mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target == nums[mid]) return mid;
            if (target == nums[lo]) return lo;
            if (nums[lo] <= nums[mid]) {
                if (target < nums[mid] && target > nums[lo]) hi = mid - 1;
                else lo = mid + 1;
            } else {
                if (target < nums[lo] && target > nums[mid]) lo = mid + 1;
                else hi = mid - 1;
            }
        }
        return -1;
    }
}
