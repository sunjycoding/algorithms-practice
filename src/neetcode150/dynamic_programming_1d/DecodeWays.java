package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 5/8/25
 */
public class DecodeWays {

    public int numDecodings(String s) {
        if (s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i - 2);
            if (a != '0') {
                dp[i] += dp[i - 1];
            }
            int num = (b - '0') * 10 + (a - '0');
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
