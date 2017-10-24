/**
 * Created by mengwliu on 10/22/17
 * 283. Move Zeroes
 */
public class p283 {
    public void moveZeroes(int[] nums) {
        int i = 0, j = 0;
        while (i < nums.length) {
            while (i < nums.length && nums[i] == 0) i++;
            if (i >= nums.length) break;
            nums[j++] = nums[i++];
        }
        while (j < nums.length) nums[j++] = 0;
    }
}
