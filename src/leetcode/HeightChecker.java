package leetcode;

import java.util.Arrays;

/**
 * 1051. Height Checker
 *
 * @author Created by sunjy on 4/24/25
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int[] expected = heights.clone();
        Arrays.sort(expected);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) {
                count++;
            }
        }
        return count;
    }

}
