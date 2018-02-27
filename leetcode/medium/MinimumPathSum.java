import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		int m=grid.length;
		if(m<1)return 0;
		int n=grid[m-1].length;
		if(n<1)return 0;
		
		int[][]minPath=new int[m][n];
		minPath[0][0]=grid[0][0];
		for(int i=1;i<n;i++) minPath[0][i]=grid[0][i]+minPath[0][i-1];
		for(int i=1;i<m;i++) minPath[i][0]=grid[i][0]+minPath[i-1][0];
		
		for(int i=1; i<m;i++) {
			for(int j=1; j<n;j++) {
					minPath[i][j]=Math.min(minPath[i-1][j],minPath[i][j-1])+grid[i][j];
			}
		}
		return minPath[m-1][n-1];
	}
	@Test
	public void test() {
		int[][]arr= {{1,3,1},{1,5,1},{4,2,1}};
		assertEquals(minPathSum(arr),7);
	}
}
