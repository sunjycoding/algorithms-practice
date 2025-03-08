package leetcode.day002;

/**
 * 11. Container With Most Water
 *
 * @author Created by sunjy on 3/5/25
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
