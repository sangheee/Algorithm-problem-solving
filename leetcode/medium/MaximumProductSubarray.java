import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if(nums.length<1)return 0;
		int max=nums[0],totalMax=nums[0];
		int min=nums[0];
		
		for(int i=1; i<nums.length;i++) {
			int n=nums[i];
			int tmp=max;
			max=Math.max(n, Math.max(max*n, min*n));
			min=Math.min(n, Math.min(tmp*n, min*n));
			if(max>totalMax) {
				totalMax=max;
			}
			
		}
		return totalMax;
	}
	
	@Test
	public void test() {
		assertEquals(maxProduct(new int[] {2,3,-2,4}),6);
		assertEquals(maxProduct(new int[] {-2,-3,7}),42);
		assertEquals(maxProduct(new int[] {2,-5,-2,-4,3}),24);
		assertEquals(maxProduct(new int[] {-2,-5,-2,-4,3}),240);
		assertEquals(maxProduct(new int[] {0,2}),2);
	}
}
