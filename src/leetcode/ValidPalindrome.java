package leetcode;

/**
 * 125. Valid Palindrome
 *
 * @author Created by sunjy on 4/16/25
 */
public class ValidPalindrome {

    //  I use two pointers scanning from both ends.
    //  If a character is not alphanumeric, I skip it.
    //  Otherwise, I compare the lowercase versions of the characters.

    //  Time O(n)
    //  Space O(1)
    public boolean isPalindrome(String s) {
        int length = s.length();
        int left = 0;
        int right = length - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!Character.isLetterOrDigit(leftChar)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(rightChar)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
