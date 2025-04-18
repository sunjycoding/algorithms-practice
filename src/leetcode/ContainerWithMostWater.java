package leetcode;

/**
 * 11. Container With Most Water
 *
 * @author Created by sunjy on 4/17/25
 */
public class ContainerWithMostWater {

    //  I use two pointers from both ends and calculate the area at each step.
    //  Then I move the shorter line inward, hoping to find a taller line to increase the area.

    //  Time O(n)
    //  Space O(1)
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

}
