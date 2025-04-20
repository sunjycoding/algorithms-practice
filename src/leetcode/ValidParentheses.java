package leetcode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 20. Valid Parentheses
 *
 * @author Created by sunjy on 4/18/25
 */
public class ValidParentheses {

    //  I use a stack to match brackets.
    //  Push left brackets into the stack. When I see a right bracket, I check if the top of the stack matches.
    //  If it doesn’t match or the stack is empty, return false.
    //  At the end, if the stack is empty, the string is valid.

    //  Time O(n)
    //  Space O(n)
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (top == '(' && ch != ')') {
                        return false;
                    }
                    if (top == '[' && ch != ']') {
                        return false;
                    }
                    if (top == '{' && ch != '}') {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }

}
