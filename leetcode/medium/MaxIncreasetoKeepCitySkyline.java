import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MaxIncreasetoKeepCitySkyline {
	public int maxIncreaseKeepingSkyline(int[][] grid) {
		int row=grid.length,col=grid[0].length;
		int[] rowMax=new int[row];
		int[] colMax=new int[col];
		
		for(int i=0; i<row;i++) {
			for(int j=0;j<col;j++) {
				int val=grid[i][j];
				rowMax[i]=Math.max(rowMax[i], val);
				colMax[j]=Math.max(colMax[j], val);
			}
		}
		
		int res=0;
		
		for(int i=0; i<row;i++) {
			for(int j=0; j<col;j++) {
				res+=Math.min(rowMax[i], colMax[j])-grid[i][j];
			}
		}
		
		return res;
	}
	
	@Test
	public void test() {
		int[][]grid= {{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}};
		assertEquals(maxIncreaseKeepingSkyline(grid),35);
	}
}
