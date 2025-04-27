package neetcode150.arrays_and_hashing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by sunjy on 4/26/25
 */
public class EncodeDecodeStrings {

    public String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String str : strs) {
            stringBuilder.append(str.length()).append('#').append(str);
        }
        return stringBuilder.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j + 1, j + 1 + length));
            i = j + 1 + length;
        }
        return result;
    }

}
