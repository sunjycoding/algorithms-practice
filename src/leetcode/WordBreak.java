package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. Word Break
 *
 * @author Created by sunjy on 4/21/25
 */
public class WordBreak {

    //  I use DP where dp[i] means whether the substring s[0..i-1] can be segmented using the dictionary.
    //  I initialize dp[0] = true.
    //  For each i, I check if there's a j such that dp[j] is true and s[j..i) is in the dictionary.
    //  The answer is dp[n]

    //  Time O(n^2)
    //  Space O(n + k)
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n];
    }

}
