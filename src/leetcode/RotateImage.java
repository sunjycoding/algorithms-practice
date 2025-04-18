package leetcode;

/**
 * 48. Rotate Image
 *
 * @author Created by sunjy on 4/17/25
 */
public class RotateImage {

    //  First, I transpose the matrix by swapping matrix[i][j] with matrix[j][i].
    //  Then, I reverse each row to achieve a 90-degree clockwise rotation.

    //  Time O(n^2)
    //  Space O(1)
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }

}
