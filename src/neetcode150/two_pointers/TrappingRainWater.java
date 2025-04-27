package neetcode150.two_pointers;

/**
 * @author Created by sunjy on 4/26/25
 */
public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        int[] sufMax = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, height[i]);
            preMax[i] = max;
        }
        max = 0;
        for (int i = n - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            sufMax[i] = max;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += Math.min(preMax[i], sufMax[i]) - height[i];
        }
        return result;
    }

}
