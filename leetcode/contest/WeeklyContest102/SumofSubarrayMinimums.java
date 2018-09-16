package contest.WeeklyContest102;

import org.junit.Test;

import java.util.Stack;

import static org.junit.Assert.assertEquals;

public class SumofSubarrayMinimums {
    //    public int sumSubarrayMins(int[] A) {
//        int mod = 1000000007;
//        int ret = 0, n = A.length;
//        Stack<int[]> stack = new Stack<>();
//        int stacksum = 0;
//        for (int i = 0; i < n; i++) {
//            int cur = 1;
//            while (!stack.isEmpty() && stack.peek()[0] >= A[i]) {
//                int[] last = stack.pop();
//                cur += last[1];
//                stacksum -= (last[0] * last[1]);
//            }
//            stack.push(new int[]{A[i], cur});
//            stacksum += (cur * A[i]);
//            ret += stacksum;
//            ret %= mod;
//        }
//
//        return ret;
//    }

    public int sumSubarrayMins(int[] A) {
        int mod = 1000000007;
        int ret = 0, n = A.length;
        int[] prev = new int[n], next = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && A[i] <= A[stack.peek()]) {
                stack.pop();
            }
            prev[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A[i] < A[stack.peek()]) {
                stack.pop();
            }
            next[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            ret += (i - prev[i]) * (next[i] - i) % mod * A[i] % mod;
            ret %= mod;
        }
        return ret;
    }

    @Test
    public void test() {
        assertEquals(593, sumSubarrayMins(new int[]{71,55,82,55}));
        assertEquals(264, sumSubarrayMins(new int[]{48, 87, 27}));
        assertEquals(17, sumSubarrayMins(new int[]{3, 1, 2, 4}));
        assertEquals(197, sumSubarrayMins(new int[]{81, 55, 2}));
    }
}
