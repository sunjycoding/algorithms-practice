package leetcode.day010;

/**
 * 42. Trapping Rain Water
 *
 * @author Created by sunjy on 4/5/25
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int length = height.length;
        int[] preMax = new int[length];
        int[] sufMax = new int[length];
        int max = 0;
        for (int i = 0; i < length; i++) {
            max = Math.max(max, height[i]);
            preMax[i] = max;
        }
        max = 0;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            sufMax[i] = max;
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return result;
    }

}
