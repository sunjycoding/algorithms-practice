package neetcode150.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 5/2/25
 */
public class EncodeDecodeStrings {

    //  Can the strings contain digits or special characters like #?
    //  Can the input list be empty or contain empty strings?
    //  Are we assuming ASCII characters only or do we need to handle Unicode?

    //  I encode each string as <length>#<string> and concatenate them.
    //  While decoding, I scan from the beginning, read until I hit # to get the length,
    //  then grab the next length characters as the string.

    //  Time O(n)
    //  Space O(n)
    public String encode(List<String> strs) {
        StringBuilder encoded = new StringBuilder();
        for (String str : strs) {
            encoded.append(str.length())
                    .append('#')
                    .append(str);
        }
        return encoded.toString();
    }

    public List<String> decode(String str) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            ans.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return ans;
    }

}
