package neetcode150.two_pointers;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ContainerWithMostWater {

    //  Can the input array be null or have fewer than 2 elements?
    //  Can the array contain negative numbers or zeros?

    //  I use two pointers starting from both ends.
    //  At each step, I compute the area between the two heights and update the maximum.
    //  Then I move the pointer at the shorter height, since the smaller height limits the area.

    //  Time O(n)
    //  Space O(1)
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(heights[left], heights[right]);
            if (heights[left] < heights[right]) {
                left++;
            } else {
                right--;
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

}
