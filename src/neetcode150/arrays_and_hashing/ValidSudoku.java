package neetcode150.arrays_and_hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ValidSudoku {

    //  Is the input board always a 9x9 grid?
    //  Are empty cells always represented by .
    //  Will the board only contain characters '1' to '9' and '.'

    //  I maintain three sets for rows, columns, and 3x3 boxes.
    //  As I iterate through each cell,
    //  I check if the current digit already exists in any of its respective sets.
    //  If it does, return false.

    //  Time O(1)
    //  Space O(1)
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
                char ch = board[i][j];
                if (ch != '.') {
                    if (rows.get(i).contains(ch)) {
                        return false;
                    }
                    rows.get(i).add(ch);
                    if (cols.get(j).contains(ch)) {
                        return false;
                    }
                    cols.get(j).add(ch);
                    int index = (i / 3) * 3 + (j / 3);
                    if (boxes.get(index).contains(ch)) {
                        return false;
                    }
                    boxes.get(index).add(ch);
                }
            }
        }
        return true;
    }

}
