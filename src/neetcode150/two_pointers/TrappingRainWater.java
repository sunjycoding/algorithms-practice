package neetcode150.two_pointers;

/**
 * @author Created by sunjy on 5/2/25
 */
public class TrappingRainWater {

    //  Can the input array be empty or have fewer than 2 elements?
    //  Are all height values guaranteed to be non-negative integers?
    //  Does each index represent a vertical bar of width 1?

    //  I use two pointers moving inward.
    //  At each step, I choose the shorter side since the water level is limited by the smaller height.
    //  I track leftMax and rightMax, the maximum heights seen so far from both sides.
    //  If the current height is less than the max, I add the trapped water.

    //  Time O(n)
    //  Space O(1)
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int ans = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax) {
                    ans += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (height[right] < rightMax) {
                    ans += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return ans;
    }

}
