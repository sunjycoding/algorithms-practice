package leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 773. Sliding Puzzle
 *
 * @author Created by sunjy on 4/22/25
 */
public class SlidingPuzzle {

    //  We flatten the 2D board into a 1D string like "123450"
    //  Then we use BFS to search from the initial state
    //  For each state, we find where '0' is and try swapping with its neighbors
    //  Use a visited set to avoid revisiting states

    //  Time O(6!)
    //  Space O(6!)
    public int slidingPuzzle(int[][] board) {
        int m = 2;
        int n = 3;
        StringBuilder stringBuilder = new StringBuilder();
        String target = "123450";
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                stringBuilder.append(board[i][j]);
            }
        }
        String start = stringBuilder.toString();
        int[][] neighbor = new int[][]{
                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {2, 4}
        };
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                assert current != null;
                if (target.equals(current)) {
                    return step;
                }
                int index = 0;
                while (current.charAt(index) != '0') {
                    index++;
                }
                for (int adj : neighbor[index]) {
                    String newBoard = swap(current.toCharArray(), adj, index);
                    if (!visited.contains(newBoard)) {
                        queue.offer(newBoard);
                        visited.add(newBoard);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}
