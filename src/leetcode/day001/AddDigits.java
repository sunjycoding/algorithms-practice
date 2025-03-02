package leetcode.day001;

/**
 * 258. Add Digits
 *
 * @author Created by sunjy on 3/1/25
 */
public class AddDigits {

    public int addDigits(int num) {
        if (num == 0) {
            return 0;
        }
        return (num % 9 == 0) ? 9 : (num % 9);
    }

}
