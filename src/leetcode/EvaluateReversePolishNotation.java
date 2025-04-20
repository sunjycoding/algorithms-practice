package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. Evaluate Reverse Polish Notation
 *
 * @author Created by sunjy on 4/18/25
 */
public class EvaluateReversePolishNotation {

    //  I use a stack to evaluate the RPN expression.
    //  If the token is a number, I push it.
    //  If it's an operator, I pop two numbers, apply the operation, and push the result back.
    //  For subtraction and division, the order of operands matters — a is popped before b.

    //  Time O(n)
    //  Space O(n)
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    int b = stack.pop();
                    int a = stack.pop();
                    stack.push(a / b);
                }
                default -> stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
