package neetcode150.heap_or_priority_queue;

import java.util.Arrays;

/**
 * @author Created by sunjy on 5/4/25
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char c : tasks) {
            count[c - 'A']++;
        }
        Arrays.sort(count);
        int maxFreq = count[25];
        int sameMax = 1;
        for (int i = 24; i >= 0; i--) {
            if (count[i] != maxFreq) {
                break;
            }
            sameMax++;
        }
        int frameSize = (maxFreq - 1) * (n + 1) + sameMax;
        return Math.max(frameSize, tasks.length);
    }

}
