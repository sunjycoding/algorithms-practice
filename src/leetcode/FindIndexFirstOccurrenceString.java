package leetcode;

/**
 * 28. Find the Index of the First Occurrence in a String
 *
 * @author Created by sunjy on 4/16/25
 */
public class FindIndexFirstOccurrenceString {

    //  If this were a production environment,
    //  I'd use indexOf() for simplicity and performance.
    //  But for learning and demonstration,
    //  I'd like to show a manual solution first using a straightforward scan (brute force).

    //  Time O(n * m)
    //  Space O(1)
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) {
            return 0;
        }
        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {
            if (haystack.substring(i, i + m).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

}
