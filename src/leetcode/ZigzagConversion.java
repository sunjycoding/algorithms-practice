package leetcode;

/**
 * 6. Zigzag Conversion
 *
 * @author Created by sunjy on 4/16/25
 */
public class ZigzagConversion {

    //  I simulate the zigzag pattern using an array of StringBuilders, one for each row.
    //  I iterate through the input string,
    //  adding each character to the correct row based on the current direction (down or up).
    //  Then I concatenate all rows together to get the final result.

    //  Time O(n)
    //  Space O(n)
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currentRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

}
