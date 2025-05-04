package leetcode;

/**
 * 1128. Number of Equivalent Domino Pairs
 *
 * @author Created by sunjy on 5/3/25
 */
public class NumberEquivalentDominoPairs {

    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int ans = 0;

        for (int[] d : dominoes) {
            int a = d[0];
            int b = d[1];
            int key = Math.min(a, b) * 10 + Math.max(a, b);
            ans += count[key];
            count[key]++;
        }

        return ans;
    }

}
