package leetcode;

/**
 * 498. Diagonal Traverse
 *
 * @author Created by sunjy on 4/24/25
 */
public class DiagonalTraverse {

    public int[] findDiagonalOrder(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return new int[0];
        }
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        int row = 0, col = 0;
        boolean up = true;

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];
            if (up) {
                if (col == n - 1) {
                    row++;
                    up = false;
                } else if (row == 0) {
                    col++;
                    up = false;
                } else {
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {
                    col++;
                    up = true;
                } else if (col == 0) {
                    row++;
                    up = true;
                } else {
                    row++;
                    col--;
                }
            }
        }

        return result;
    }

}
