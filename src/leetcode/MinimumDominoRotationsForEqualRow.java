package leetcode;

/**
 * 1007. Minimum Domino Rotations For Equal Row
 *
 * @author Created by sunjy on 5/2/25
 */
public class MinimumDominoRotationsForEqualRow {

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int rotations = check(tops[0], tops, bottoms);
        if (rotations != -1 || tops[0] == bottoms[0]) {
            return rotations;
        }
        return check(bottoms[0], tops, bottoms);
    }

    private int check(int target, int[] tops, int[] bottoms) {
        int topRotations = 0;
        int bottomRotations = 0;
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != target && bottoms[i] != target) {
                return -1;
            }
            if (tops[i] != target) {
                topRotations++;
            }
            if (bottoms[i] != target) {
                bottomRotations++;
            }
        }
        return Math.min(topRotations, bottomRotations);
    }

}
