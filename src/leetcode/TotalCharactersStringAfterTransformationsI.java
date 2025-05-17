package leetcode;

/**
 * 3335. Total Characters in String After Transformations I
 *
 * @author Created by sunjy on 5/13/25
 */
public class TotalCharactersStringAfterTransformationsI {


    public int lengthAfterTransformations(String s, int t) {
        int mod = 1_000_000_007;
        long[] count = new long[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (int i = 0; i < t; i++) {
            long[] next = new long[26];
            for (int c = 0; c < 26; c++) {
                if (c == 25) {
                    next[0] = (next[0] + count[25]) % mod;
                    next[1] = (next[1] + count[25]) % mod;
                } else {
                    next[c + 1] = (next[c + 1] + count[c]) % mod;
                }
            }
            count = next;
        }

        long ans = 0;
        for (long c : count) {
            ans = (ans + c) % mod;
        }
        return (int) ans;
    }

}
