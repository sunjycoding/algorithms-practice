package leetcode;

/**
 * 134. Gas Station
 *
 * @author Created by sunjy on 4/16/25
 */
public class GasStation {

    //  I first calculate the total gas - cost.
    //  If the total is negative, then it’s impossible to complete the circuit.
    //  Then I simulate driving from station 0. If at some point the tank goes negative,
    //  I know all stations before that point can’t be a valid start,
    //  so I reset the start index to the next station.

    // Time O(n)
    // Space O(1)
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        int tank = 0;
        int start = 0;

        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;

            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return total < 0 ? -1 : start;
    }

}
