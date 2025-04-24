package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1451. Rearrange Words in a Sentence
 *
 * @author Created by sunjy on 4/23/25
 */
public class RearrangeWordsSentence {

    //  I split the sentence into words, lowercase the first word,
    //  sort by word length, then capitalize the first word again.
    //  Finally, I join the words into a sentence.

    //  Time O(nlogn)
    //  Space O(n)
    public String arrangeWords(String text) {
        String[] words = text.split(" ");
        words[0] = Character.toLowerCase(words[0].charAt(0)) + words[0].substring(1);
        Arrays.sort(words, Comparator.comparingInt(String::length));
        words[0] = Character.toUpperCase(words[0].charAt(0)) + words[0].substring(1);
        return String.join(" ", words);
    }

}
