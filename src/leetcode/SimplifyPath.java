package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 71. Simplify Path
 *
 * @author Created by sunjy on 4/18/25
 */
public class SimplifyPath {

    //  I split the path by /, then use a deque to simulate a stack.
    //  I pop from the back for "..", skip "." and empty parts, and push valid names.
    //  Finally, I build the result by polling from the front. If empty, return "/".

    //  Time O(n)
    //  Space O(n)
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for (String name : names) {
            if ("..".equals(name)) {
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else if (!name.isEmpty() && !".".equals(name)) {
                stack.offerLast(name);
            }
        }
        StringBuilder result = new StringBuilder();
        if (stack.isEmpty()) {
            result.append('/');
        } else {
            while (!stack.isEmpty()) {
                result.append('/');
                result.append(stack.pollFirst());
            }
        }
        return result.toString();
    }

}
