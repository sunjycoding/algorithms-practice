package leetcode;

/**
 * 2379. Minimum Recolors to Get K Consecutive Black Blocks
 *
 * @author Created by sunjy on 5/24/25
 */
public class MinimumRecolorsGetKConsecutiveBlackBlocks {

    public int minimumRecolors(String blocks, int k) {
        int min = Integer.MAX_VALUE;
        int count = 0;
        int left = 0;
        for (int right = 0; right < blocks.length(); right++) {
            if (blocks.charAt(right) == 'W') {
                count++;
            }
            if (right - left + 1 == k) {
                min = Math.min(min, count);
                if (blocks.charAt(left) == 'W') {
                    count--;
                }
                left++;
            }
        }
        return min;
    }

}
