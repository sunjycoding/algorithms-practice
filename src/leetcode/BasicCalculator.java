package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 *
 * @author Created by sunjy on 4/18/25
 */
public class BasicCalculator {

    //  I use a stack to store the state before each (.
    //  When I see ), I pop and combine the result.
    //  I track the current sign with a sign variable and parse numbers digit by digit.
    //  The solution runs in linear time.

    //  Time O(n)
    //  Space O(n)
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                number = number * 10 + (ch - '0');
            } else if (ch == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (ch == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (ch == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (ch == ')') {
                result += sign * number;
                number = 0;
                result *= stack.pop();
                result += stack.pop();
            }
        }

        return result + sign * number;
    }

}
