package neetcode150.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Created by sunjy on 5/3/25
 */
public class MinStack {

    //  Can I use two stacks? Are there any space constraints?
    //  Should getMin() run in O(1) time?

    //  I maintain two stacks: one for the actual elements, and one for tracking the minimum at each state.
    //  When I push, I also push the smaller of the current value and the previous min onto minStack.
    //  Both stacks pop together, and getMin() just returns the top of minStack
    private final Deque<Integer> stack;
    private final Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }

}
