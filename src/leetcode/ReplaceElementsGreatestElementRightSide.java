package leetcode;

/**
 * 1299. Replace Elements with Greatest Element on Right Side
 *
 * @author Created by sunjy on 4/24/25
 */
public class ReplaceElementsGreatestElementRightSide {

    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int max = -1;
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[i];
            arr[i] = max;
            max = Math.max(temp, max);
        }
        return arr;
    }

}
