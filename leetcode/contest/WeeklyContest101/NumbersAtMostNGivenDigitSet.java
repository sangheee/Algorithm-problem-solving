package contest.WeeklyContest101;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class NumbersAtMostNGivenDigitSet {
    public int atMostNGivenDigitSet(String[] D, int N) {
        int n = D.length;
        char[] c = Integer.toString(N).toCharArray();
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            d[i] = Integer.valueOf(D[i]);
        }
        Arrays.sort(d);

        int t = 0;//N의 자릿수
        for (int tmp = N; tmp > 0; tmp /= 10, t++) ;

        int ret = 0;

        for (int digit = 1; t >= digit; digit++) {
            if (digit < t) {
                ret += Math.pow(n, digit);
            } else if (digit == t) {
                for (int i = 0; i < t; i++) {
                    int idx = Arrays.binarySearch(d, c[i] - '0');
                    if (idx < 0) {
                        ret += ((-idx - 1) * Math.pow(n, t - i - 1));
                        break;
                    }
                    if (i == (t - 1)) idx++;
                    ret += (int) (idx * Math.pow(n, t - i - 1));

                }
            }
        }
        return ret;
    }

    @Test
    public void test() {
        assertEquals(3, atMostNGivenDigitSet(new String[]{"1"}, 834));
        assertEquals(2, atMostNGivenDigitSet(new String[]{"5", "6"}, 19));
        assertEquals(6, atMostNGivenDigitSet(new String[]{"5", "7", "8"}, 59));
        assertEquals(1, atMostNGivenDigitSet(new String[]{"1", "2", "3"}, 1));
        assertEquals(2, atMostNGivenDigitSet(new String[]{"3", "4", "8"}, 4));
        assertEquals(1, atMostNGivenDigitSet(new String[]{"7"}, 8));
        assertEquals(20, atMostNGivenDigitSet(new String[]{"1", "3", "5", "7"}, 100));
    }
}
