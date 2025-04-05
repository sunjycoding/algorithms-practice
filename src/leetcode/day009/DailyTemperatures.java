package leetcode.day009;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 *
 * @author Created by sunjy on 4/4/25
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] res = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int prevIndex = stack.pop();
                res[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }

        return res;
    }

}
