package neetcode150.arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Created by sunjy on 4/26/25
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> grids = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            grids.add(new HashSet<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char ch = board[i][j];
                if (ch != '.') {
                    if (rows.get(i).contains(ch)) {
                        return false;
                    }
                    rows.get(i).add(ch);
                    if (cols.get(i).contains(ch)) {
                        return false;
                    }
                    cols.get(i).add(ch);
                    int index = (i / 3) * 3 + (j / 3);
                    if (grids.get(index).contains(ch)) {
                        return false;
                    }
                    grids.get(index).add(ch);
                }
            }
        }
        return true;
    }

}
