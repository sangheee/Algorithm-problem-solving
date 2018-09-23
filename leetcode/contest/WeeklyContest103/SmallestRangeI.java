package contest.WeeklyContest103;

import java.util.*;

public class SmallestRangeI {
    // nlogn solution -sorting
    public int smallestRangeI_sorting(int[] A, int K) {
        Arrays.sort(A);
        int diff = (A[A.length - 1] - K) - (A[0] + K);
        return diff < 0 ? 0 : diff;
    }
    //n solution - get max, min
    public int smallestRangeI(int[] A, int K) {
        int min = A[0], max = A[0];
        for (int a : A) {
            min = Math.min(min, a);
            max = Math.max(max, a);
        }
        return Math.max(0, max - min - 2 * K);
    }
}
