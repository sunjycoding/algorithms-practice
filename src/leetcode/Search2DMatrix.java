package leetcode;

/**
 * 74. Search a 2D Matrix
 *
 * @author Created by sunjy on 4/19/25
 */
public class Search2DMatrix {

    //  I treat the 2D matrix as a flattened 1D array.
    //  To convert index i back to 2D, I use row = i / n, col = i % n.
    //  Since each row has n elements, this mapping is always correct.

    //  Time O(log(m * n))
    //  Space O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int rowIndex = mid / n;
            int colIndex = mid % n;
            if (matrix[rowIndex][colIndex] < target) {
                left = mid + 1;
            } else if (matrix[rowIndex][colIndex] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
