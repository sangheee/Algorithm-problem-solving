import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinimumSwapsToMakeSequencesIncreasing {
	public int minSwap(int[] A, int[] B) {
		return getMinSwap(A,B,1,0);
	}
	private int getMinSwap(int[]A, int[]B, int i,int res) {
		if(i>=A.length)return 0;
		if(A[i-1]==A[i] || B[i-1]==B[i]) {
			res=Math.min(getMinSwap(A,B,i+1,res), getMinSwap(A,B,i+2,res))+1;
		}else res+=(A[i]<A[i-1]||B[i]<B[i-1]?1:0)+getMinSwap(A,B,i+1,res);
		return res;
	}
	
	@Test
	public void test() {
		assertEquals(minSwap(new int[]{1,3,5,4},new int[]{1,2,3,7 }),1);
		assertEquals(minSwap(new int[]{3,3,8,9,10},new int[]{1,7,4,6,8 }),1);
		assertEquals(minSwap(new int[]{2,3,2,5,6},new int[]{0,1,4,4,5 }),1);
	}
}
