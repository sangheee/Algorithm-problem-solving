import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class WordSearch {
	private static final int[] dx= {1,-1,0,0};
	private static final int[] dy= {0,0,-1,1};
	
	public boolean exist(char[][] board, String word) {
		if(board==null || board.length==0)return false;
		char[] w=word.toCharArray();
		boolean[][] visited=new boolean[board.length][board[0].length];
		
		for(int i=0; i<board.length;i++) {
			for(int j=0; j<board[i].length;j++) {
				if(dfs(board,visited,w,i,j,0))
					return true;
			}
		}
		return false;
	}
	
	
	private boolean dfs(char[][]board, boolean[][] visited, char[] w, int x,int y,int charIdx) {
		if(w.length==charIdx)return true;
		if(x<0||y<0||x>=board.length||y>=board[0].length||visited[x][y] ||board[x][y]!=w[charIdx])return false;
	
		
		boolean res=false;
		visited[x][y]=true;
		for(int i=0;i<4;i++) {
			int newX=x+dx[i],newY=y+dy[i];
			res|=dfs(board,visited,w,newX,newY,charIdx+1);
			if(res)break;
		}
		visited[x][y]=false;
		return res;
	}
	
	
	@Test
	public void test() {
		char[][] board={{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		assertTrue(exist(board,"ABCCED"));
		board=new char[][] {{'a','b'}};
		assertTrue(exist(board,"ba"));
	}
}
