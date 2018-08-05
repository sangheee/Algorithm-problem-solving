package contest.WeeklyContest96;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ProjectionAreaof3DShapes {
    public int projectionArea(int[][] grid) {
        int ret=0;
        int[] maxHeight=new int[grid.length];
        int[] maxWeight=new int[grid[0].length];
        for (int i=0; i<grid.length;i++){
            for (int j=0; j<grid[i].length;j++){
                if(grid[i][j]>0)ret++;
                maxHeight[i]=Math.max(maxHeight[i],grid[i][j]);
                maxWeight[j]=Math.max(maxWeight[j],grid[i][j]);
            }
        }
        for (int n:maxHeight)ret+=n;
        for (int n:maxWeight)ret+=n;
        return ret;
    }
    @Test
    public void test(){
        assertEquals(5,projectionArea(new int[][]{{2}}));
    }
}
