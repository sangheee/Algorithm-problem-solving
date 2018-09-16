package contest.WeeklyContest102;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class SumofSubarrayMinimums {
    public int sumSubarrayMins(int[] A) {
        int mod = 1000000007;
        int ret = 0, n = A.length;
        Stack<int[]> stack = new Stack<>();
        int stacksum = 0;
        for (int i = 0; i < n; i++) {
            int cur = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= A[i]) {
                int[] last = stack.pop();
                cur += last[1];
                stacksum -= (last[0] * last[1]);
            }
            stack.push(new int[]{A[i], cur});
            stacksum += (cur * A[i]);
            ret += stacksum;
            ret %= mod;
        }

        return ret;
    }

    @Test
    public void test() {
        assertEquals(264, sumSubarrayMins(new int[]{48, 87, 27}));
        assertEquals(17, sumSubarrayMins(new int[]{3, 1, 2, 4}));
        assertEquals(197, sumSubarrayMins(new int[]{81, 55, 2}));
    }
}
