package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. Min Stack
 *
 * @author Created by sunjy on 4/18/25
 */
public class MinStack {

    //  I use two stacks: one for values, one for the current minimum at each position.
    //  Each time I push, I compare the new value with the current min, and push the smaller one into minStack.
    //  So getMin() is always in O(1) time by peeking at the top of minStack.
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
