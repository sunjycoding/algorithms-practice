package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 210. Course Schedule II
 *
 * @author Created by sunjy on 4/23/25
 */
public class CourseScheduleII {

    //  I used BFS to implement topological sort,
    //  tracking the indegree of each course.
    //  I enqueue all courses with zero indegree,
    //  then process them and update the indegree of their neighbors.
    //  If I process all courses, I return the result.
    //  If not, it means there's a cycle.

    //  Time O(V + E)
    //  Space O(V + E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] p : prerequisites) {
            graph.get(p[1]).add(p[0]);
            indegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int course = queue.poll();
            order[index++] = course;

            for (int next : graph.get(course)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return index == numCourses ? order : new int[0];
    }

}
