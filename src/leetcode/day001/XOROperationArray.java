package leetcode.day001;

/**
 * 1486. XOR Operation in an Array
 *
 * @author Created by sunjy on 3/1/25
 */
public class XOROperationArray {

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            int num = start + 2 * i;
            result ^= num;
        }
        return result;
    }

}
