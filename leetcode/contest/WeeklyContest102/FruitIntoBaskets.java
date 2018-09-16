package contest.WeeklyContest102;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FruitIntoBaskets {
    public int totalFruit(int[] tree) {
        int max = Integer.MIN_VALUE;
        int l = 1, r = 0;
        int sum = 0;
        int prelast = -1, last = -1;

        for (int i = 0; i < tree.length; i++) {
            int t = tree[i];
            if (t == last) {
                sum++;
                r++;
            } else if (t == prelast) {
                sum++;
                prelast = last;
                last = t;
                l = r = i;
            } else {
                max = Math.max(max, sum);
                sum = r - l + 2;
                l = r = i;
                prelast = last;
                last = t;
            }
        }
        return Math.max(max, sum);
    }

    @Test
    public void test() {
        assertEquals(3, totalFruit(new int[]{1, 2, 1}));
        assertEquals(3, totalFruit(new int[]{0, 1, 2, 2}));
    }
}
