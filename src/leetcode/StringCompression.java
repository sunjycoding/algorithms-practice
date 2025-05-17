package leetcode;

/**
 * 443. String Compression
 *
 * @author Created by sunjy on 5/15/25
 */
public class StringCompression {

    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;

            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }

            chars[write] = currentChar;
            write++;

            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int i = 0; i < countStr.length(); i++) {
                    chars[write] = countStr.charAt(i);
                    write++;
                }
            }
        }

        return write;
    }

}
