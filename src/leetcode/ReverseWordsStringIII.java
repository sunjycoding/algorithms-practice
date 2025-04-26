package leetcode;

/**
 * 557. Reverse Words in a String III
 *
 * @author Created by sunjy on 4/24/25
 */
public class ReverseWordsStringIII {

    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            sb.append(new StringBuilder(words[i]).reverse());
            if (i < words.length - 1) {
                sb.append(" ");
            }
        }

        return sb.toString();
    }

}
