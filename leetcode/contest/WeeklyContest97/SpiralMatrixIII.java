package contest.WeeklyContest97;

import org.junit.Test;


public class SpiralMatrixIII {

    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] ret = new int[R * C][];
        ret[0] = new int[]{r0, c0};

        int v = 1;
        int[][] spiral = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int direct = 0;
        int[] cur = new int[]{r0, c0};
        int i = 1;

        while (i < R * C) {
            for (int j = 1; j <= v; j++) {
                cur[0] += spiral[direct][0];
                cur[1] += spiral[direct][1];

                if ((cur[0] >= 0 && cur[0] < R) && (cur[1] >= 0 && cur[1] < C)) {
                    ret[i++] = new int[]{cur[0], cur[1]};
                }
            }
            direct++;
            if (direct % 2 == 0) v++;
            if (direct >= 4) direct %= 4;
        }
        return ret;
    }

    @Test
    public void test() {
        int[][] res=spiralMatrixIII(1, 4, 0, 0);
        for (int[] r: res)
            System.out.println(r[0]+" "+r[1]);
    }
}
