import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by mengwliu on 10/25/17.
 * 253. Meeting Rooms II
 */
public class p253 {
    public int minMeetingRooms(Interval[] intervals) {
        PriorityQueue<Integer> list = new PriorityQueue<>();
        Arrays.sort(intervals, (a, b)->a.start - b.start);
        for (Interval interval : intervals) {
            if (list.size() == 0) list.offer(interval.end);
            else {
                int lastEnd = list.peek();
                if (lastEnd <= interval.start) {
                    list.poll();
                }
                list.offer(interval.end);
            }
        }
        return list.size();
    }
    public static void main(String[] args) {
        Interval[] intervals = new Interval[6];
        intervals[0] = new Interval(1293, 2986);
        intervals[1] = new Interval(848, 3846);
        intervals[2] = new Interval(4284, 5907);
        intervals[3] = new Interval(4466, 4781);
        intervals[4] = new Interval(518, 2918);
        intervals[5] = new Interval(300, 5870);
        p253 sol = new p253();
        sol.minMeetingRooms(intervals);
    }
}
