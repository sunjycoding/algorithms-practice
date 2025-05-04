package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Created by sunjy on 5/3/25
 */
public class ValidParentheses {

    //  Does the input string contain only ()[]{} characters?
    //  Can the input string be empty? And is it considered valid?

    //  I use a stack to keep track of unmatched opening brackets.
    //  For each opening bracket, I push it.
    //  For each closing bracket, I check if it matches the top of the stack.
    //  If not, or if the stack is empty, I return false.
    //  At the end, the stack should be empty to be valid.

    //  Time O(n)
    //  Space O(n)
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
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
        return stack.isEmpty();
    }

}
