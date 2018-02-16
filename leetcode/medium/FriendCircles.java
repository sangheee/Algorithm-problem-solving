import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class FriendCircles {
	@Test
	public void test() {
		assertEquals(1,findCircleNum(new int[][] {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
		assertEquals(1,findCircleNum(new int[][] {{1,1,0},{1,1,1},{0,1,1}}));
	}
	
	public int findCircleNum(int[][] M) {
		int n=M.length,ret=n;
		
		int[]friends=new int[n];
		for(int i=0;i<n;i++)friends[i]=i;
		
		for(int i=0; i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if(M[i][j]==1) {
					int p=find(friends,i);
					int c=find(friends,j);
					if(p!=c) {
						friends[c]=p;
						ret--;
					}
				}
			}
		}
		return ret;
	}
	
	private int find(int[] friends, int u) {
		while(friends[u]!=u) {
			friends[u]=friends[friends[u]];
			u=friends[u];
		}
		return u;
	}
}
