package contest.WeeklyContest99;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SurfaceAreaof3DShapes {
    public int surfaceArea(int[][] grid) {
        int N = grid.length;
        int sum = 0;
        if (N < 1) return sum;

        int[][] way4 = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] > 0) {
                    sum += 2;
                    for (int k = 0; k < 4; k++) {
                        int newx = i + way4[k][0], newy = j + way4[k][1];
                        if ((newx >= N || newx < 0) || (newy >= N || newy < 0)) {
                            sum+=grid[i][j];
                        }else if(grid[newx][newy]<grid[i][j]){
                            sum+=grid[i][j]-grid[newx][newy];
                        }
                    }
                }
            }
        }
        return sum;
    }

    @Test
    public void test() {
        assertEquals(46, surfaceArea(new int[][]{{2,2, 2}, {2,1, 2},{2,2,2}}));
        assertEquals(16, surfaceArea(new int[][]{{1, 0}, {0, 2}}));
        assertEquals(32, surfaceArea(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}}));
    }
}
