package leetcode;

/**
 * 151. Reverse Words in a String
 *
 * @author Created by sunjy on 4/16/25
 */
public class ReverseWordsString {

    //  I trim the string, split it using regex \\s+ to handle multiple spaces,
    //  then append the words in reverse order.
    //  This approach runs in O(n) time and handles all whitespace edge cases cleanly.

    //  Time O(n)
    //  Space O(n)
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(" ");
            }
        }

        return result.toString();
    }

}
