import java.util.*;

public class SwimInRisingWater {
	private final int[][] steps= {{0,1},{0,-1},{1,0},{-1,0}};
	/*
	private int swimInWater(int[][] grid) {
		int n=grid.length;
		int[][] max=new int[n][n];
		for(int []line:max)Arrays.fill(line, Integer.MAX_VALUE);
		dfs(grid,max,0,0,grid[0][0]);
		return max[n-1][n-1];
	}
	private void dfs(int[][] grid, int[][] max, int x, int y, int cur) {
		int n=grid.length;
		
		if(x<0 ||y<0||x>=n||y>=n ||Math.max(cur, grid[x][y])>=max[x][y])return;
		max[x][y]=Math.max(cur, grid[x][y]);
		for(int []s:steps) {
			dfs(grid,max,x+s[0],y+s[1],max[x][y]);
		}
	}*/
	
    public int swimInWater(int[][] grid) {
		int n=grid.length;
		int min=Math.max(grid[0][0], grid[n-1][n-1]);
		int max=(int) (Math.pow(n, 2)-1);
		
		while(min<max) {
			int mid=min+(max-min)/2;
			boolean[][] visited=new boolean[n][n];
			if(dfs(grid,visited,0,0,mid))
				max=mid;
			else 
				min=mid+1;
			
		}
		return min;
    }
	private boolean dfs(int[][] grid, boolean[][] visited, int x,int y,int max) {
		
		int n=grid.length;
		visited[x][y]=true;
		for(int[] step:steps) {
			int newx=x+step[0],newy=y+step[1];
			if(newx>=0 && newx<n &&newy>=0 &&newy<n && !visited[newx][newy] && grid[newx][newy]<=max) {
				if(newx==n-1 &&newy==n-1)return true;
				if(dfs(grid,visited,newx,newy,max))return true;
			}
		}
		return false;
	}
}
