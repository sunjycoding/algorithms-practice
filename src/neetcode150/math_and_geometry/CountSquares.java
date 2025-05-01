package neetcode150.math_and_geometry;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by sunjy on 4/30/25
 */
public class CountSquares {

    private Map<String, Integer> pointCount;

    public CountSquares() {
        pointCount = new HashMap<>();
    }

    public void add(int[] point) {
        String key = point[0] + ":" + point[1];
        pointCount.put(key, pointCount.getOrDefault(key, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        int res = 0;

        for (String key : pointCount.keySet()) {
            String[] parts = key.split(":");
            int x1 = Integer.parseInt(parts[0]);
            int y1 = Integer.parseInt(parts[1]);

            if (Math.abs(x - x1) != Math.abs(y - y1) || x == x1 || y == y1) {
                continue;
            }

            String p2 = x + ":" + y1;
            String p3 = x1 + ":" + y;

            int c1 = pointCount.getOrDefault(p2, 0);
            int c2 = pointCount.getOrDefault(p3, 0);
            int c3 = pointCount.getOrDefault(key, 0);

            res += c1 * c2 * c3;
        }

        return res;
    }
}