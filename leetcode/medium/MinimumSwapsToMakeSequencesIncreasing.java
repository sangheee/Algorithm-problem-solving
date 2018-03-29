import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumSwapsToMakeSequencesIncreasing {
	public int minSwap(int[] A, int[] B) {
		int res=0;
		for(int i=1,j=1; i<A.length && j<B.length;i++,j++) {
			if(A[i-1]>=A[i] || B[j-1]>=B[j]) res++;
		}
		return res;
	}
	
	@Test
	public void test() {
		assertEquals(minSwap(new int[]{1,3,5,4},new int[]{1,2,3,7 }),1);
		assertEquals(minSwap(new int[]{3,3,8,9,10},new int[]{1,7,4,6,8 }),1);
	}
}
