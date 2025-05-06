package neetcode150.backtracking;

/**
 * @author Created by sunjy on 5/4/25
 */
public class WordSearch {

    //  Can the board be empty?
    //  Can the word contain non-alphabet characters?

    //  I use DFS with backtracking. Starting from each cell,
    //  I try to match the word by exploring in four directions.
    //  I temporarily mark a cell as visited using #,
    //  and backtrack after recursion to restore the character.

    //  Time O(m × n × 3^L)
    //  Space O(L)
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (backtrack(board, word, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, String word, int index, int row, int col) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board.length || board[row][col] != word.charAt(index)) {
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';
        boolean found = backtrack(board, word, index + 1, row + 1, col) ||
                backtrack(board, word, index + 1, row - 1, col) ||
                backtrack(board, word, index + 1, row, col + 1) ||
                backtrack(board, word, index + 1, row, col - 1);
        board[row][col] = temp;
        return found;
    }

}
