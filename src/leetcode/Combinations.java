package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * @author Created by sunjy on 4/21/25
 */
public class Combinations {

    //  I use backtracking to explore all combinations.
    //  I start each loop from the current index to avoid duplicates.
    //  Once the current list reaches size k, I add it to the result.

    //  Time O(C(n, k) * k)
    //  Space O(C(n, k) * k)
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int index, int n, int k, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = index; i <= n; i++) {
            current.add(i);
            backtrack(i + 1, n, k, current, result);
            current.removeLast();
        }
    }

}
