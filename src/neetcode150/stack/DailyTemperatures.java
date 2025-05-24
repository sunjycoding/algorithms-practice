package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Created by sunjy on 5/3/25
 */
public class DailyTemperatures {

    //  I'm using a monotonic decreasing stack that stores indices.
    //  When I find a temperature that is higher than the temperature at the top of the stack,
    //  I know the warmer day has arrived,
    //  so I calculate the difference in indices to get the answer.

    //  Time O(n)
    //  Space O(n)
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                ans[index] = i - index;
            }
            stack.push(i);
        }
        return ans;
    }

}
