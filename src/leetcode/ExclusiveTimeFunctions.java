package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

/**
 * 636. Exclusive Time of Functions
 *
 * @author Created by sunjy on 5/8/25
 */
public class ExclusiveTimeFunctions {

    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        int prevTime = 0;

        for (String log : logs) {
            String[] parts = log.split(":");
            int id = Integer.parseInt(parts[0]);
            String type = parts[1];
            int time = Integer.parseInt(parts[2]);

            if ("start".equals(type)) {
                if (!stack.isEmpty()) {
                    ans[stack.peek()] += time - prevTime;
                }
                stack.push(id);
                prevTime = time;
            } else {
                ans[stack.pop()] += time - prevTime + 1;
                prevTime = time + 1;
            }
        }
        return ans;
    }

    private int calculate(String start, String end) {
        int startTime = Integer.parseInt(start.substring(start.lastIndexOf(":") + 1));
        int endTime = Integer.parseInt(end.substring(end.lastIndexOf(":") + 1));
        return endTime - startTime + 1;
    }

}
