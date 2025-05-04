package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Created by sunjy on 5/3/25
 */
public class EvaluateReversePolishNotation {

    //  Is the input guaranteed to be a valid RPN expression?
    //  Should division be integer division? How should negative results be handled?
    //  Are only +, -, *, and / operators allowed?

    //  I use a stack to simulate the evaluation.
    //  I push numbers onto the stack.
    //  When I see an operator, I pop the top two numbers,
    //  perform the operation, and push the result back.
    //  For - and /, I ensure operand order is preserved.

    //  Time O(n)
    //  Space O(n)
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    stack.push(stack.pop() + stack.pop());
                }
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    stack.push(stack.pop() * stack.pop());
                }
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> {
                    stack.push(Integer.parseInt(token));
                }
            }

        }
        return stack.pop();
    }

}
