package leetcode;

/**
 * 289. Game of Life
 *
 * @author Created by sunjy on 4/17/25
 */
public class GameLife {

    //  2 means alive → dead
    //  3 means dead → alive
    //  This preserves the original state while I compute neighbors, and I finalize the state in the last pass.

    //  Time O(m × n)
    //  Space O(1)
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] directions = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1}, {0, 1},
                {1, -1}, {1, 0}, {1, 1}
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;

                for (int[] d : directions) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni >= 0 && ni < m && nj >= 0 && nj < n &&
                            (board[ni][nj] == 1 || board[ni][nj] == 2)) {
                        live++;
                    }
                }

                if (board[i][j] == 1 && (live < 2 || live > 3)) {
                    board[i][j] = 2;
                }
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] %= 2;
            }
        }
    }

}
