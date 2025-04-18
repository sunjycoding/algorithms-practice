package leetcode;

/**
 * 9. Palindrome Number
 *
 * @author Created by sunjy on 4/17/25
 */
public class PalindromeNumber {

    //  Instead of reversing the entire number, I reverse half of it.
    //  Once the original number is less than or equal to the reversed half, I stop and compare.
    //  This avoids integer overflow and is more efficient.

    //  Time O(log10n)
    //  Space O(1)
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }

        return x == reversed || x == reversed / 10;
    }

}
