package neetcode150.arrays_and_hashing;

/**
 * @author Created by sunjy on 5/2/25
 */
public class ValidAnagram {

    //  Can either input string be null?
    //  Do the strings only contain lowercase English letters?
    //  Should we treat two empty strings as valid anagrams?

    //  I’m using an int array of size 26 to count the frequency of each letter.
    //  For each character in s I increment the count,
    //  and for each character in t I decrement it.
    //  If at the end all counts are zero, then the strings are anagrams.

    //  Time O(n)
    //  Space O(1)
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i : count) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

}
