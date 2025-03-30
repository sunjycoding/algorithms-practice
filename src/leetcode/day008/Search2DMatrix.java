package leetcode.day008;

/**
 * 74. Search a 2D Matrix
 *
 * @author Created by sunjy on 3/28/25
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int left = -1;
        int right = rows * cols;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if (matrix[row][col] < target) {
                left = mid;
            } else if (matrix[row][col] > target) {
                right = mid;
            } else {
                return true;
            }
        }
        return false;
    }

}
