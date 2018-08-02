import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DominoTrominoTiling {
	int MOD=1000000007;
	public int numTilings(int N) {
		int[] canTile=new int[1001];
		canTile[1]=1;
		canTile[2]=2;
		int cur=2;
		for(int i=3;i<=N;i++) {
			canTile[i]=(canTile[i-1]+canTile[i-2])%MOD+cur;
			canTile[i]%=MOD;
			
			cur=(cur+canTile[i-2])%MOD + canTile[i-2];
			cur%=MOD;
			
		}
		return canTile[N];
		
	}
	@Test
	public void test() {
		assertEquals(numTilings(3),5);
		assertEquals(numTilings(4),11);
		assertEquals(numTilings(5),24);
		assertEquals(numTilings(30),312342182);
	}
}
