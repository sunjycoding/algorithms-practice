package neetcode150.binary_search;

/**
 * @author Created by sunjy on 4/26/25
 */
public class Search2DMatrix {

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int i = mid / n;
            int j = mid % n;
            if (matrix[i][j] < target) {
                left = mid + 1;
            } else if (matrix[i][j] > target) {
                right = mid;
            } else {
                return true;
            }
        }
        return false;
    }

}
