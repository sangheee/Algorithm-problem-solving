
public class NumberOfIslands {
	private static final int[] x = { 0, 0, -1, 1 };
	private static final int[] y = { 1, -1, 0, 0 };

	public int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;

		int N = grid.length;
		int[][] visited = new int[N][grid[0].length];

		int num = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (visited[i][j] == 0) {
					num = Math.max(num, getIslandsNumber(grid, visited, i, j, num));
				}
			}
		}
		return num;
	}

	private int getIslandsNumber(char[][] grid, int[][] visited, int i, int j, int num) {
		if (visited[i][j] !=0)
			return visited[i][j];
		if (grid[i][j] == '0') {
			visited[i][j] = -1;
			return -1;
		}
		visited[i][j] = num + 1;
		for (int idx = 0; idx < 4; idx++) {
			if (isRange(grid, i + x[idx], j + y[idx])) {
				getIslandsNumber(grid, visited, i + x[idx], j + y[idx], num);
			}
		}
		return visited[i][j];
	}

	private boolean isRange(char[][] grid, int x, int y) {
		if (x < 0 || y < 0 || grid.length <= x || grid[x].length <= y)return false;
		return true;
	}
}
