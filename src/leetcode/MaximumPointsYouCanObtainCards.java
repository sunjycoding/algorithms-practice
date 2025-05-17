package leetcode;

/**
 * 1423. Maximum Points You Can Obtain from Cards
 *
 * @author Created by sunjy on 5/16/25
 */
public class MaximumPointsYouCanObtainCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int score = 0;
        for (int cardPoint : cardPoints) {
            score += cardPoint;
        }
        if (k == n) {
            return score;
        }
        int currScore = 0;
        int minScore = score;
        int left = 0;
        for (int right = 0; right < n; right++) {
            currScore += cardPoints[right];
            while (right - left + 1 > n - k) {
                currScore -= cardPoints[left];
                left++;
            }
            if (right - left + 1 == n - k) {
                minScore = Math.min(minScore, currScore);
            }
        }
        return score - minScore;
    }

}
