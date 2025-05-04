package neetcode150.binary_search;

/**
 * @author Created by sunjy on 5/3/25
 */
public class Search2DMatrix {

    //  Is each row sorted in ascending order? Is the entire matrix globally sorted?
    //  Can we treat the 2D matrix as a flattened sorted 1D array?

    //  We treat the matrix as a flattened 1D sorted array,
    //  mapping index mid back to (i = mid / n, j = mid % n).
    //  Then we perform a standard binary search as if it's a 1D array.

    //  Time O(log(m * n))
    //  Space O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else if (matrix[i][j] > target) {
                right = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

}
