package leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 3342. Find Minimum Time to Reach Last Room II
 *
 * @author Created by sunjy on 5/7/25
 */
public class FindMinimumTimeReachLastRoomII {

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int[][] visited = new int[n][m];
        for (int[] row : visited) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        visited[0][0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], x = curr[1], y = curr[2];

            // 到达终点
            if (x == n - 1 && y == m - 1) {
                return time;
            }

            // 向四个方向探索
            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                int arriveTime = time + 1;

                if (arriveTime < moveTime[nx][ny]) {
                    arriveTime = moveTime[nx][ny];
                }

                if ((arriveTime % 2) != (moveTime[nx][ny] % 2)) {
                    arriveTime++;
                }

                if (arriveTime < visited[nx][ny]) {
                    visited[nx][ny] = arriveTime;
                    pq.offer(new int[]{arriveTime, nx, ny});
                }
            }
        }

        return -1;
    }

}
