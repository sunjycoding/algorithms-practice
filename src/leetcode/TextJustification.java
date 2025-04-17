package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 4/16/25
 */
public class TextJustification {

    //  I use a greedy approach: fill each line with as many words as possible.
    //  When the line is full, I justify it by distributing spaces evenly between words.
    //  If spaces can't be evenly divided, the left slots get more spaces. The last line is left-justified.

    //  Time O(n * maxWidth)
    //  Space O(1)
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;

        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;

            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) {
                    break;
                }
                totalChars += 1 + words[last].length();
                last++;
            }

            StringBuilder line = new StringBuilder();
            int numWords = last - index;
            if (last == words.length || numWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) {
                        line.append(" ");
                    }
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spaces = maxWidth - (totalChars - (numWords - 1));
                int spaceEach = spaces / (numWords - 1);
                int extra = spaces % (numWords - 1);

                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) {
                        for (int s = 0; s < spaceEach; s++) {
                            line.append(" ");
                        }
                        if (extra-- > 0) {
                            line.append(" ");
                        }
                    }
                }
            }

            result.add(line.toString());
            index = last;
        }
        return result;
    }

}
