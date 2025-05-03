package neetcode150.two_pointers;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ValidPalindrome {

    //  Can the input string be empty or contain only whitespace?
    //  Should we ignore non-alphanumeric characters?
    //  Is the comparison case-sensitive?

    //  I use two pointers moving from both ends toward the center.
    //  I skip any non-alphanumeric characters.
    //  At each step, I compare the characters after converting to lowercase.
    //  If they don't match, return false.

    //  Time O(n)
    //  Space O(1)
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            char chLeft = s.charAt(left);
            char chRight = s.charAt(right);
            if (!Character.isLetterOrDigit(chLeft)) {
                left++;
                continue;
            }
            if (!Character.isLetterOrDigit(chRight)) {
                right--;
                continue;
            }
            if (Character.toLowerCase(chLeft) !=
                    Character.toLowerCase(chRight)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
