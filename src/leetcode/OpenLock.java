package leetcode;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 752. Open the Lock
 *
 * @author Created by sunjy on 4/22/25
 */
public class OpenLock {

    //  Think of each lock combination as a node in a graph.
    //  Each node has 8 neighbors — turning each wheel up or down by one.
    //  We use BFS starting from "0000" and search level by level.
    //  We skip any state in deadends and keep a visited set to avoid cycles.

    //  Time O(10^4)
    //  Space O(10^4)
    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        Collections.addAll(deads, deadends);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String current = queue.poll();
                assert current != null;
                if (deads.contains(current)) {
                    continue;
                }
                if (target.equals(current)) {
                    return steps;
                }
                for (int j = 0; j < 4; j++) {
                    String up = up(current, j);
                    String down = down(current, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            steps++;
        }
        return -1;
    }

    private String up(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '9') {
            ch[i] = '0';
        } else {
            ch[i] += 1;
        }
        return new String(ch);
    }

    private String down(String s, int i) {
        char[] ch = s.toCharArray();
        if (ch[i] == '0') {
            ch[i] = '9';
        } else {
            ch[i] -= 1;
        }
        return new String(ch);
    }

}
