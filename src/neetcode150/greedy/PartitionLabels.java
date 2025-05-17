package neetcode150.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/13/25
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] last = new int[26];

        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if (i == end) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }

        return res;
    }

}
