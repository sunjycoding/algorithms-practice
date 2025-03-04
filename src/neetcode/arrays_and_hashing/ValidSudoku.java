package neetcode.arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Valid Sudoku
 *
 * @author Created by sunjy on 3/3/25
 */
public class ValidSudoku {

    Set<Integer> rows = new HashSet<>();
    Set<Integer> cols = new HashSet<>();
    Set<Integer> boxes = new HashSet<>();

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num == '.') {
                    continue;
                }
                if (rows.get(i).contains(num)) {
                    return false;
                }
                rows.get(i).add(num);
                if (cols.get(j).contains(num)) {
                    return false;
                }
                cols.get(j).add(num);
                int boxIndex = (i / 3) * 3 + (j / 3);
                if (boxes.get(boxIndex).contains(num)) {
                    return false;
                }
                boxes.get(boxIndex).add(num);
            }
        }
        return true;
    }

}
