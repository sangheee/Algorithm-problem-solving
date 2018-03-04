
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NumberOfSubarraysWithBoundedMaximum {
	public int numSubarrayBoundedMax(int[] A, int L, int R) {
		int res=0;
		int l=0,r=-1;
		for(int i=0;i<A.length;i++) {
			if(isRange(A[i],L,R)) {
				r=i;
				res+=r-l+1;
			}else if(A[i]<L && r>=l) {
				res+=r-l+1;
			}else if(A[i]>R){
				l=i+1;
				r=i;
			}
		}
		return res;	
	}
	
	private boolean isRange(int n,int L,int R) {
		if(n<L|| n>R)return false;
		return true;
	}
	@Test
	public void test() {
		assertEquals(numSubarrayBoundedMax(new int[] {16,69,88,85,79,87,37,33,39,34},55,57),0);
		assertEquals(numSubarrayBoundedMax(new int[] {1,1,1,2,1,4,3},2,3),9);
		assertEquals(numSubarrayBoundedMax(new int[] {2,9,2,5,6},2,8),7);
		assertEquals(numSubarrayBoundedMax(new int[] {2,1,4,3},2,4),9);
		assertEquals(numSubarrayBoundedMax(new int[] {2,1,4,3},2,3),3);
	}
}
