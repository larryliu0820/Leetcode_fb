/**
 * Created by Larry Liu on 10/25/2017.
 * 215. Kth Largest Element in an Array
 */
public class p215 {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, 0, nums.length-1, k-1);
    }

    private int helper(int[] nums, int start, int end, int k) {
        int pivotInd = partition(nums, start, end, (start + end) / 2);
        if (pivotInd == k) return nums[pivotInd];
        else if (pivotInd < k) return helper(nums, pivotInd+1, end, k);
        else return helper(nums, start, pivotInd-1, k);
    }

    private int partition(int[] nums, int start, int end, int index) {
        swap(nums, end, index);
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[end]) swap(nums, i, start++);
        }
        swap(nums, start, end);
        return start;
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
