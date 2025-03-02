package leetcode.day001;

/**
 * 867. Transpose Matrix
 *
 * @author Created by sunjy on 3/1/25
 */
public class TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transposed = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transposed[j][i] = matrix[i][j];
            }
        }
        return transposed;
    }

}
