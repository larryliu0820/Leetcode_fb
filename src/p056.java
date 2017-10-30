import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Larry Liu on 10/29/2017.
 * 56. Merge Intervals
 */
public class p056 {
    public List<Interval> merge(List<Interval> intervals) {
        intervals.sort((i1, i2)->i1.start-i2.start);
        List<Interval> res = new LinkedList<>();
        Interval itr = intervals.get(0);
        for (Interval interval: intervals) {
            if (interval.start < itr.end) {
                itr.end = Math.max(itr.end, interval.end);
            } else {
                res.add(itr);
                itr = interval;
            }
        }
        res.add(itr);
        return res;
    }
}
