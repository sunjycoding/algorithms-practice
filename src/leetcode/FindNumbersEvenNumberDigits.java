package leetcode;

/**
 * 1295. Find Numbers with Even Number of Digits
 *
 * @author Created by sunjy on 4/24/25
 */
public class FindNumbersEvenNumberDigits {

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (countDigits(num) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

    private int countDigits(int num) {
        int count = 0;
        while (num >= 1) {
            count++;
            num = num / 10;
        }
        return count;
    }
}
