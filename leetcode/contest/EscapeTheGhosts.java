import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class EscapeTheGhosts {

	public boolean escapeGhosts(int[][] ghosts, int[] target) {
		int val=Math.abs(target[0])+Math.abs(target[1]);
		for(int[] g:ghosts) {
			int g0=Math.abs(g[0]-target[0]);
			int g1=Math.abs(g[1]-target[1]);
			if(g0+g1<val)return false;
		}
		return true;
	}
	@Test
	public void test() {
		assertFalse(escapeGhosts(new int[][] {{5,0},{-10,-2},{0,-5},{-2,-2},{-7,1}},new int[]{7,7}));
		assertTrue(escapeGhosts(new int[][] {{1,0},{0,3}},new int[]{0,1}));
		assertFalse(escapeGhosts(new int[][] {{1,0}},new int[]{2,0}));
	}
}
