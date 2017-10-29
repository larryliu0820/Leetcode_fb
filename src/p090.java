import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/27/2017.
 */
public class p090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        Arrays.sort(nums);
        List<List<Integer>> source = res;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> temp = new LinkedList<>();
            for (List<Integer> list: source) {
                List<Integer> copy = new LinkedList<>(list);
                copy.add(nums[i]);
                temp.add(copy);
            }
            res.addAll(temp);
            if (i < nums.length - 1 && nums[i] == nums[i+1]) source = temp;
            else source = res;
        }
        return res;
    }
}
