package leetcode;

/**
 * 479. Largest Palindrome Product
 *
 * @author Created by sunjy on 4/23/25
 */
public class LargestPalindromeProduct {

    //   I construct even-length palindromes by appending the reverse of a number
    //   to itself using integer math.
    //   Then I check if the palindrome can be factored into two n-digit numbers.
    //   I also added an optimization — if x * x < palindrome,
    //   further checks are unnecessary so I break early.

    //  Time O(N^2)
    //  Space O(1)
    public int largestPalindrome(int n) {
        if (n == 1) {
            return 9;
        }
        int upper = (int) Math.pow(10, n) - 1;
        int result = 0;
        for (int left = upper; result == 0; --left) {
            long p = left;
            for (int x = left; x > 0; x /= 10) {
                p = p * 10 + x % 10;
            }
            for (long x = upper; x * x >= p; --x) {
                if (p % x == 0) {
                    result = (int) (p % 1337);
                    break;
                }
            }
        }
        return result;
    }

}
