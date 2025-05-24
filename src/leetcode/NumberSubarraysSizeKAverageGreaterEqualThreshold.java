package leetcode;

/**
 * 1343. Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
 *
 * @author Created by sunjy on 5/24/25
 */
public class NumberSubarraysSizeKAverageGreaterEqualThreshold {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < arr.length; right++) {
            sum += arr[right];
            while (right - left + 1 == k) {
                if (sum / k >= threshold) {
                    count++;
                }
                sum -= arr[left];
                left++;
            }
        }
        return count;
    }

}
