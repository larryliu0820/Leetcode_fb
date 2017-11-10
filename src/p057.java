import java.util.LinkedList;
import java.util.List;

/**
 * Created by mengwliu on 10/31/17
 * 57. Insert Interval
 */
public class p057 {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> res = new LinkedList<>();
        int i = 0;
        while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
            res.add(intervals.get(i++));
        }

        while (i < intervals.size() && newInterval.end >= intervals.get(i).start) {
            newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
            newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            i++;
        }

        res.add(newInterval);

        while (i < intervals.size()) res.add(intervals.get(i++));

        return res;

    }

}
