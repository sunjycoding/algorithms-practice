package leetcode;

/**
 * 12. Integer to Roman
 *
 * @author Created by sunjy on 4/16/25
 */
public class IntegerRoman {

    //  I use a greedy approach.
    //  I maintain a list of Roman symbols and their values sorted from largest to smallest.
    //  For each value, I subtract it as many times as possible while appending the corresponding Roman numeral.

    //  Time O(1)
    //  Space O(1)
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];

            while (num >= value) {
                num -= value;
                stringBuilder.append(symbol);
            }
        }

        return stringBuilder.toString();
    }

}
