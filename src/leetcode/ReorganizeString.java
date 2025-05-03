package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 767. Reorganize String
 *
 * @author Created by sunjy on 5/2/25
 */
public class ReorganizeString {

    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
            if (freq.get(c) > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap =
                new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        maxHeap.addAll(freq.entrySet());

        StringBuilder sb = new StringBuilder();

        while (maxHeap.size() >= 2) {
            Map.Entry<Character, Integer> e1 = maxHeap.poll();
            Map.Entry<Character, Integer> e2 = maxHeap.poll();

            sb.append(e1.getKey());
            sb.append(e2.getKey());

            if (e1.getValue() - 1 > 0) {
                e1.setValue(e1.getValue() - 1);
                maxHeap.offer(e1);
            }

            if (e2.getValue() - 1 > 0) {
                e2.setValue(e2.getValue() - 1);
                maxHeap.offer(e2);
            }
        }

        if (!maxHeap.isEmpty()) {
            sb.append(maxHeap.poll().getKey());
        }

        return sb.toString();
    }

}
