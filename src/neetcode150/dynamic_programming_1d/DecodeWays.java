package neetcode150.dynamic_programming_1d;

/**
 * @author Created by sunjy on 4/27/25
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
            char oneDigit = s.charAt(i - 1);
            char twoDigitFirst = s.charAt(i - 2);
            if (oneDigit != '0') {
                dp[i] += dp[i - 1];
            }
            int twoDigit = (twoDigitFirst - '0') * 10 + (oneDigit - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }

}
