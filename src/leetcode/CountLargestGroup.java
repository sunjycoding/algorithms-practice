package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1399. Count Largest Group
 *
 * @author Created by sunjy on 4/22/25
 */
public class CountLargestGroup {

    //  For each number from 1 to n, compute its digit sum as the group key
    //  Use a HashMap<Integer, Integer> to track the frequency of each digit sum
    //  Find the maximum group size
    //  Count how many groups have that size

    //  Time O(nlogn)
    //  Space O(n)
    public int countLargestGroup(int n) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int maxValue = 0;
        for (int i = 1; i <= n; ++i) {
            int key = 0, i0 = i;
            while (i0 != 0) {
                key += i0 % 10;
                i0 /= 10;
            }
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
            maxValue = Math.max(maxValue, hashMap.get(key));
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == maxValue) {
                count++;
            }
        }
        return count;
    }

}
