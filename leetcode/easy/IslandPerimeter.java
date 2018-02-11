
public class IslandPerimeter {
	/*private int[] x= new int[] {0,0,1,-1};
	private int[] y=new int[] {1,-1,0,0};
	
	public int islandPerimeter(int[][] grid) {
		int result=0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0; j<grid[i].length;j++) {
				if(grid[i][j]==1) {
					for(int k=0;k<4;k++) {
						if(!isRange(grid,i+x[k],j+y[k]) || grid[i+x[k]][j+y[k]]==0)result++;
					}
				}
				
			}
		}
		return result;
	}

	private boolean isRange(int[][] grid, int i, int j) {
		if((i>=0 && i<grid.length) &&(j>=0 &&j<grid[i].length))return true;
		return false;
	}
	*/
	public int islandPerimeter(int[][] grid) {
		int result=0;
		for(int i=0; i<grid.length;i++) {
			for(int j=0; j<grid[i].length;j++) {
				if(grid[i][j]==1) {
					result+=4;
					if(i>0 && grid[i-1][j]==1)result-=2;
					if(j>0 && grid[i][j-1]==1)result-=2;
				}
			}
		}
		return result;
	}
}
