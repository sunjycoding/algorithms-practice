package leetcode;

import java.util.Map;

/**
 * 13. Roman to Integer
 *
 * @author Created by sunjy on 4/16/25
 */
public class RomanInteger {

    //  I scan the string left to right.
    //  If the current value is less than the next value, I subtract it (special subtractive case),
    //  otherwise I add it to the total.

    //  Time O(n)
    //  Space O(1)
    public int romanToInt(String s) {
        Map<Character, Integer> map = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);
        int total = 0;

        for (int i = 0; i < s.length(); i++) {
            int currentValue = map.get(s.charAt(i));
            if (i + 1 < s.length() && currentValue < map.get(s.charAt(i + 1))) {
                total -= currentValue;
            } else {
                total += currentValue;
            }
        }
        return total;
    }

}
