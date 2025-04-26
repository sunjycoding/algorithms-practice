package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle II
 *
 * @author Created by sunjy on 4/24/25
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i <= rowIndex; i++) {
            result.add(1);
        }

        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                result.set(j, result.get(j - 1) + result.get(j));
            }
        }

        return result;
    }

}
