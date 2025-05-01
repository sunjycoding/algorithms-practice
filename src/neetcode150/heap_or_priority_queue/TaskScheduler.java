package neetcode150.heap_or_priority_queue;

import java.util.Arrays;

/**
 * @author Created by sunjy on 4/27/25
 */
public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char c : tasks) {
            freq[c - 'A']++;
        }

        Arrays.sort(freq);
        int maxFreq = freq[25];
        int maxCount = 1;

        for (int i = 24; i >= 0; i--) {
            if (freq[i] == maxFreq) {
                maxCount++;
            } else {
                break;
            }
        }

        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxCount;
        int idles = Math.max(0, emptySlots - availableTasks);

        return tasks.length + idles;
    }

}
