package leetcode.day005;

/**
 * 240. Search a 2D Matrix II
 *
 * @author Created by sunjy on 3/11/25
 */
public class Search2DMatrixII {

    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length - 1;
        int row = 0;
        while (col >= 0 && row <= matrix.length - 1) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }
        return false;
    }

}
