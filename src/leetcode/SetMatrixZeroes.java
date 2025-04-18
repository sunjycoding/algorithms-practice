package leetcode;

/**
 * 73. Set Matrix Zeroes
 *
 * @author Created by sunjy on 4/17/25
 */
public class SetMatrixZeroes {

    //  I first check if the first row and first column originally contain any zeros, since I will use them as flags.
    //  Then, I use the first row and column to mark rows and columns that should be zeroed.
    //  Finally, I update the matrix based on those markers, and process the first row and column separately.

    //  Time O(m × n)
    //  Space O(1)
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;
        for (int[] arr : matrix) {
            if (arr[0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int col = 0; col < cols; col++) {
            if (matrix[0][col] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }
        if (firstRowHasZero) {
            for (int col = 0; col < cols; col++) {
                matrix[0][col] = 0;
            }
        }
        if (firstColHasZero) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }

}
