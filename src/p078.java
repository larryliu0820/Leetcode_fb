import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/24/2017.
 * 78. Subsets
 */
public class p078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        res.add(new LinkedList<>());
        for (int num: nums) {
            List<List<Integer>> temp = new LinkedList<>();
            for (List<Integer> list: res) {
                List<Integer> copy = new LinkedList<>(list);
                copy.add(num);
                temp.add(copy);
            }
            res.addAll(temp);
        }
        return res;
    }
}
