package leetcode;

/**
 * 79. Word Search
 *
 * @author Created by sunjy on 4/21/25
 */
public class WordSearch {

    //  This is essentially a DFS on a grid.
    //  I start DFS from each cell, and recursively explore in 4 directions
    //  if the current character matches the word.
    //  I mark visited cells temporarily and restore them when backtracking.

    //  Time O(m * n * 4^L)
    //  Space O(L)
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int x, int y) {
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length ||
                board[x][y] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) {
            return true;
        }

        char temp = board[x][y];
        board[x][y] = '#';

        boolean found = dfs(board, word, index + 1, x + 1, y)
                || dfs(board, word, index + 1, x - 1, y)
                || dfs(board, word, index + 1, x, y + 1)
                || dfs(board, word, index + 1, x, y - 1);

        board[x][y] = temp;
        return found;
    }

}
