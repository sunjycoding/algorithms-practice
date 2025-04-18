package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku
 *
 * @author Created by sunjy on 4/17/25
 */
public class ValidSudoku {

    //  I use a HashSet to track where each digit has appeared — in which row, column, or 3x3 grid.
    //  I encode this info into strings like "5 in row 0" and check for duplicates.

    //  Time O(1)
    //  Space O(1)
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Integer>> rowMap = new HashMap<>();
        Map<Integer, Set<Integer>> colMap = new HashMap<>();
        Map<Integer, Set<Integer>> gridMap = new HashMap<>();
        int rows = board.length;
        int cols = board[0].length;
        for (int i = 0; i < 9; i++) {
            rowMap.put(i, new HashSet<>());
            colMap.put(i, new HashSet<>());
            gridMap.put(i, new HashSet<>());
        }
        for (int i = 0; i < rows; i++) {
            Set<Integer> rowSet = rowMap.get(i);
            for (int j = 0; j < cols; j++) {
                int val = board[i][j];
                if (val == '.') {
                    continue;
                }
                //row
                if (rowSet.contains(val)) {
                    return false;
                }
                //col
                Set<Integer> colSet = colMap.get(j);
                if (colSet.contains(val)) {
                    return false;
                }
                //grid
                int gridNumber = (i / 3) * 3 + (j / 3);
                Set<Integer> gridSet = gridMap.get(gridNumber);
                if (gridSet.contains(val)) {
                    return false;
                }
                rowSet.add(val);
                colSet.add(val);
                gridSet.add(val);
            }
        }
        return true;
    }

}
