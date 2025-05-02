package neetcode150.intervals;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author Created by sunjy on 5/1/25
 */
public class MeetingRoomsII {

    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        intervals.sort(Comparator.comparingInt(a -> a.start));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (Interval interval : intervals) {
            if (!minHeap.isEmpty() && interval.start >= minHeap.peek()) {
                minHeap.poll();
            }
            minHeap.offer(interval.end);
        }

        return minHeap.size();
    }

    public static class Interval {
        public int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
