package leetcode;

/**
 * 1342. Number of Steps to Reduce a Number to Zero
 *
 * @author Created by sunjy on 5/10/25
 */
public class NumberStepsReduceNumberZero {

    public int numberOfSteps(int num) {
        int[] dp = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            if (i % 2 == 0) {
                dp[i] = dp[i / 2] + 1;
            } else {
                dp[i] = dp[i - 1] + 1;
            }
        }
        return dp[num];
    }

}
