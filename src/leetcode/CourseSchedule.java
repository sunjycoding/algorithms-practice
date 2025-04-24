package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 207. Course Schedule
 *
 * @author Created by sunjy on 4/23/25
 */
public class CourseSchedule {

    //   I used DFS to check for cycles in a directed graph.
    //   I track nodes on the current path using an onPath array.
    //   If I revisit a node on the path, there's a cycle and we can't finish all courses.

    //  Time O(V + E)，V is amount of courses
    //  Space O(V + E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && hasCycle(graph, i, visited, onPath)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int node, boolean[] visited, boolean[] onPath) {
        visited[node] = true;
        onPath[node] = true;
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(graph, neighbor, visited, onPath)) {
                    return true;
                }
            } else if (onPath[neighbor]) {
                return true;
            }
        }
        onPath[node] = false;
        return false;
    }

}
