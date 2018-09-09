package contest.WeeklyContest101;

import java.util.ArrayList;
import java.util.List;

public class RLEIterator {
    List<Integer> arr;
    List<Integer> freq;

    public RLEIterator(int[] A) {
        arr = new ArrayList();
        freq = new ArrayList();
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] != 0) {
                freq.add(A[i]);
                arr.add(A[i + 1]);
            }
        }
    }

    public int next(int n) {
        if (arr.isEmpty() || freq.isEmpty()) return -1;
        int curr = freq.get(0);
        if (curr < n) {
            freq.remove(0);
            arr.remove(0);
            return next(n - curr);
        } else {
            freq.set(0, curr - n);
            return arr.get(0);
        }
    }
}
