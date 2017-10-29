import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/28/2017.
 * 334. Increasing Triplet Subsequence
 */
public class p334 {
    public boolean increasingTriplet(int[] nums) {
        List<Integer> res = new LinkedList<>();
        for (int num: nums) {

            if (res.size() == 0 || res.get(res.size()-1) < num) {
                res.add(num);
            } else {
                if (num > res.get(0) && num < res.get(1)) {
                    res.remove(1);
                    res.add(1, num);
                } else if (num < res.get(0)){
                    res.remove(0);
                    res.add(0, num);
                }
            }
            if (res.size() == 3) return true;
        }
        return false;
    }

}
