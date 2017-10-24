import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by mengwliu on 10/22/17
 * 252. Meeting Rooms
 */
public class p252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));
        int lastEnd = -1;
        for (Interval interval: intervals) {
            if (interval.start < lastEnd) return false;
            else {
                lastEnd = interval.end;
            }
        }
        return true;
    }
}
