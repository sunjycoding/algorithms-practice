package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * @author Created by sunjy on 4/17/25
 */
public class SpiralMatrix {

    //  I maintain four boundaries — top, bottom, left, and right — and simulate spiral movement in layers.
    //  Each iteration visits the current border and shrinks inward. Time complexity is O(m × n).

    //  Time O(m × n)
    //  Space O(1)
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

}
