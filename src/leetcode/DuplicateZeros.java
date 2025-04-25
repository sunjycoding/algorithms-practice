package leetcode;

/**
 * 1089. Duplicate Zeros
 *
 * @author Created by sunjy on 4/24/25
 */
public class DuplicateZeros {

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int zeros = 0;

        for (int i : arr) {
            if (i == 0) {
                zeros++;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int j = i + zeros;
            if (j < n) {
                arr[j] = arr[i];
            }

            if (arr[i] == 0) {
                zeros--;
                if (i + zeros < n) {
                    arr[i + zeros] = 0;
                }
            }
        }
    }

}
