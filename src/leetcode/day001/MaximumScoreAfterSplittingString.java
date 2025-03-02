package leetcode.day001;

/**
 * 1422. Maximum Score After Splitting a String
 *
 * @author Created by sunjy on 3/1/25
 */
public class MaximumScoreAfterSplittingString {

    public int maxScore(String s) {
        int left = 0;
        int right = 0;
        if (s.charAt(0) == '0') {
            left = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                right++;
            }
        }
        int score = left + right;
        int max = score;
        for (int i = 1; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                score--;
            } else {
                score++;
            }
            max = Math.max(max, score);
        }
        return max;
    }

}
