package neetcode150.greedy;

/**
 * @author Created by sunjy on 5/13/25
 */
public class MergeTripletsFormTarget {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] good = new boolean[3];

        for (int[] triplet : triplets) {
            if (triplet[0] > target[0] || triplet[1] > target[1] || triplet[2] > target[2]) {
                continue;
            }

            if (triplet[0] == target[0]) {
                good[0] = true;
            }
            if (triplet[1] == target[1]) {
                good[1] = true;
            }
            if (triplet[2] == target[2]) {
                good[2] = true;
            }
        }

        return good[0] && good[1] && good[2];
    }

}
