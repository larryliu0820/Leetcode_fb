/**
 * Created by mengwliu on 10/22/17
 * 26. Remove Duplicates from Sorted Array
 */
public class p026 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) return nums.length;
        int i = 1, j = 0;
        while (i < nums.length) {
            if (nums[j] == nums[i]) i++;
            else {
                nums[++j] = nums[i++];
            }
        }
        return j+1;
    }
}
