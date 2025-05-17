package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2900. Longest Unequal Adjacent Groups Subsequence I
 *
 * @author Created by sunjy on 5/14/25
 */
public class LongestUnequalAdjacentGroupsSubsequenceI {

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> ans = new ArrayList<>();
        int n = words.length;
        ans.add(words[0]);
        int prev = groups[0];
        for (int i = 1; i < n; i++) {
            if (groups[i] != prev) {
                ans.add(words[i]);
                prev = groups[i];
            }
        }
        return ans;
    }

}
