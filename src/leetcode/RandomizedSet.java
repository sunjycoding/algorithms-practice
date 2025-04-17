package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * @author Created by sunjy on 4/16/25
 */
public class RandomizedSet {

    //  To support O(1) insertion, deletion, and random access, I use a HashMap and an ArrayList.
    //  The ArrayList stores the elements so we can do getRandom() in O(1).
    //  The HashMap stores the value → index mapping.
    //  For deletion, I swap the target with the last element and remove the last one — to maintain O(1) deletion.

    private List<Integer> list;
    private Map<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.get(val);
        int last = list.getLast();

        list.set(index, last);
        map.put(last, index);

        list.removeLast();
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

}
