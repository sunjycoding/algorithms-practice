package neetcode150.greedy;

import java.util.TreeMap;

/**
 * @author Created by sunjy on 5/13/25
 */
public class HandStraights {

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }

        TreeMap<Integer, Integer> count = new TreeMap<>();
        for (int card : hand) {
            count.put(card, count.getOrDefault(card, 0) + 1);
        }

        while (!count.isEmpty()) {
            int first = count.firstKey();

            for (int i = 0; i < groupSize; i++) {
                int card = first + i;
                if (!count.containsKey(card)) {
                    return false;
                }

                count.put(card, count.get(card) - 1);
                if (count.get(card) == 0) {
                    count.remove(card);
                }
            }
        }

        return true;
    }

}
