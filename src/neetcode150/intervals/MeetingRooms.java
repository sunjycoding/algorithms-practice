package neetcode150.intervals;

import java.util.Comparator;
import java.util.List;

/**
 * @author Created by sunjy on 4/30/25
 */
public class MeetingRooms {

    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        for (int i = 1; i < intervals.size(); i++) {
            if (intervals.get(i).start < intervals.get(i - 1).end) {
                return false;
            }
        }

        return true;
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
