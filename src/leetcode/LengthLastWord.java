package leetcode;

/**
 * 58. Length of Last Word
 *
 * @author Created by sunjy on 4/16/25
 */
public class LengthLastWord {

    //  I scan the string from the end, skip trailing spaces, and count the length of the last word.

    //  Time O(n)
    //  Space O(1)
    public int lengthOfLastWord(String s) {
        int result = 0;
        int length = s.length();
        int i = length - 1;

        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        while (i >= 0 && s.charAt(i) != ' ') {
            result++;
            i--;
        }

        return result;
    }

}
