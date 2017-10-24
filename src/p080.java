/**
 * Created by Larry Liu on 10/23/2017.
 * 80. Remove Duplicates from Sorted Array II
 */
public class p080 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int i = 1, j = 1;
        boolean duplicate = false;
        while (j < nums.length) {
            if (nums[j-1] == nums[j]) {
                if (!duplicate) {
                    duplicate = true;
                    nums[i++] = nums[j];
                }
                j++;
            } else {
                duplicate = false;
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
