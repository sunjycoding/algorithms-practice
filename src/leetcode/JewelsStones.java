package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. Jewels and Stones
 *
 * @author Created by sunjy on 4/25/25
 */
public class JewelsStones {

    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            set.add(jewels.charAt(i));
        }
        int result = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (set.contains(stones.charAt(i))) {
                result++;
            }
        }
        return result;
    }

}
