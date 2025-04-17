package leetcode;

import java.util.Arrays;

/**
 * 274. H-Index
 *
 * @author Created by sunjy on 4/16/25
 */
public class HIndex {

    //  I sort the citations array in ascending order.
    //  Then I iterate from the end, counting how many papers have citations ≥ i.
    //  Once that count exceeds the citation number, I can return the answer.

    //  Time O(nlogn)
    //  Space O(1)
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int h = n - i;
            if (citations[i] >= h) {
                return h;
            }
        }
        return 0;
    }

}
