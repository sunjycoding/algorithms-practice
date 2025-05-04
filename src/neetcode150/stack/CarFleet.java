package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * @author Created by sunjy on 5/3/25
 */
public class CarFleet {

    //  Sort cars by position descending. Then from the furthest car,
    //  compute how long it takes each to reach the target.
    //  If the time is greater than the top of the stack, it forms a new fleet.
    //  Otherwise, it merges into the fleet ahead of it.

    //  Time O(nlogn)
    //  Space O(n)
    public int carFleet(int target, int[] position, int[] speed) {
        int length = position.length;
        double[][] cars = new double[length][2];
        for (int i = 0; i < length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        ArrayDeque<Double> stack = new ArrayDeque<>();
        for (double[] car : cars) {
            if (stack.isEmpty() || car[1] > stack.peek()) {
                stack.push(car[1]);
            }
        }
        return stack.size();
    }

}
