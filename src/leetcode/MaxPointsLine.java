package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 *
 * @author Created by sunjy on 4/17/25
 */
public class MaxPointsLine {

    //  For each point i, I compute the slope between i and every other point.
    //  I use a hashmap to count how many times each slope appears.
    //  I handle duplicates separately and track the global maximum.

    //  Time O(n^2)
    //  Space O(n)
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return n;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            int duplicates = 1;
            int localMax = 0;

            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    duplicates++;
                } else {
                    int gcd = getGCD(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String slopeKey = dx + "/" + dy;
                    slopeMap.put(slopeKey, slopeMap.getOrDefault(slopeKey, 0) + 1);
                    localMax = Math.max(localMax, slopeMap.get(slopeKey));
                }
            }

            max = Math.max(max, localMax + duplicates);
        }

        return max;
    }

    private int getGCD(int a, int b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

}
