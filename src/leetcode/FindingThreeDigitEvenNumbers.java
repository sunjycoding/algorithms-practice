package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2094. Finding 3-Digit Even Numbers
 *
 * @author Created by sunjy on 5/11/25
 */
public class FindingThreeDigitEvenNumbers {

    public int[] findEvenNumbers(int[] digits) {
        List<Integer> res = new ArrayList<>();
        int[] freq = new int[10];
        for (int digit : digits) {
            freq[digit]++;
        }
        for (int num = 100; num <= 998; num += 2) {
            int[] currFreq = new int[10];
            int n = num;
            currFreq[n % 10]++;
            n /= 10;
            currFreq[n % 10]++;
            n /= 10;
            currFreq[n]++;
            boolean canForm = true;
            for (int i = 0; i < 10; i++) {
                if (currFreq[i] > freq[i]) {
                    canForm = false;
                    break;
                }
            }
            if (canForm) {
                res.add(num);
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

}
