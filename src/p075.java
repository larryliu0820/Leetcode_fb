/**
 * Created by Larry Liu on 10/24/2017.
 * 75. Sort Colors
 */
public class p075 {
    public void sortColors(int[] nums) {
        int hi = nums.length-1, lo = 0;
        for (int i = 0; i <= hi; i++) {
            while (nums[i] == 2 && i < hi) swap(nums, i, hi--);
            while (nums[i] == 0 && i > lo) swap(nums, i, lo++);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
