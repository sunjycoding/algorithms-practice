package leetcode.day001;

/**
 * 1534. Count Good Triplets
 *
 * @author Created by sunjy on 3/1/25
 */
public class CountGoodTriplets {

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int result = 0;
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                for (int k = j + 1; k < length; k++) {
                    boolean conditionA = Math.abs(arr[i] - arr[j]) <= a;
                    boolean conditionB = Math.abs(arr[j] - arr[k]) <= b;
                    boolean conditionC = Math.abs(arr[i] - arr[k]) <= c;
                    if (conditionA && conditionB && conditionC) {
                        result++;
                    }
                }
            }
        }
        return result;
    }

}
