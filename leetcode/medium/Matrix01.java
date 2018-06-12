import java.util.LinkedList;
import java.util.Queue;

public class Matrix01 {
	private int[][] xy= {{0,1},{1,0},{0,-1},{-1,0}};
	public int[][] updateMatrix(int[][] matrix) {
		int len=matrix.length;
		if(len<1)return matrix;
		
		boolean[][] visited=new boolean[len][];
		Queue<int[]> queue=new LinkedList<>(); 
		for(int i=0; i<len;i++) {
			visited[i]=new boolean[matrix[i].length];
			for(int j=0; j<matrix[i].length;j++) {
				if(matrix[i][j]==0) {
					queue.add(new int[] {i,j});
					visited[i][j]=true;
				}
			}
		}
		
		int stage=1;
		int num=queue.size(),next=0;
		while(!queue.isEmpty()) {
			if(num==0) {
				num=next;
				next=0;
				stage++;
			}
			
			int[] cur=queue.poll();
			
			num--;
			for(int i=0; i<xy.length;i++) {
				int x=cur[0]+xy[i][0];
				int y=cur[1]+xy[i][1];
				if((x>=0 && x<matrix.length) && (y>=0 && y<matrix[x].length) &&!visited[x][y]) {
					matrix[x][y]=stage;
					queue.add(new int[] {x,y});
					visited[x][y]=true;
					next++;
				}	
			}
		}
		return matrix;
	}
}
