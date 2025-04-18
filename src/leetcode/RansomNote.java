package leetcode;

/**
 * 383. Ransom Note
 *
 * @author Created by sunjy on 4/17/25
 */
public class RansomNote {

    //  I use an array of size 26 to count letter frequencies in magazine.
    //  Then I scan ransomNote, and for each character, I check if the count is positive. If not, return false.
    //  Each character is used only once, and I decrement the count.

    //  Time O(m + n)
    //  Space O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine.length() < ransomNote.length()) {
            return false;
        }
        int[] dictionary = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            dictionary[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (dictionary[ransomNote.charAt(i) - 'a'] == 0) {
                return false;
            }
            dictionary[ransomNote.charAt(i) - 'a']--;
        }
        return true;
    }

}
