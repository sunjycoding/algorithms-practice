package neetcode150.graphs;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/11/25
 */
public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            graph.get(pair[1]).add(pair[0]);
        }
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, i)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(List<List<Integer>> graph, int[] visited, int node) {
        if (visited[node] == 1) {
            return false;
        }
        if (visited[node] == 2) {
            return true;
        }
        visited[node] = 1;
        for (int neighbor : graph.get(node)) {
            if (!dfs(graph, visited, neighbor)) {
                return false;
            }
        }
        visited[node] = 2;
        return true;
    }

}
