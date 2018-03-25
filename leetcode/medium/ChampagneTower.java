import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ChampagneTower {
	public double champagneTower(int poured, int query_row, int query_glass) {
		double[] cur=new double[1];
		cur[0]=poured;
		for(int i=1; i<=query_row; i++) {
			double[] pre=cur;
			cur=new double[i+1];
			for(int j=0; j<pre.length;j++) {
				if(pre[j]>1) {
					pre[j]--;
					cur[j]+=pre[j]/2;
					cur[j+1]+=pre[j]/2;
				}
			}
		}
		return cur[query_glass]/1>=1?1:cur[query_glass];
	}
	@Test 
	public void test() {
		assertEquals(0.5,champagneTower(2,1,1),0.001);
	}
}
