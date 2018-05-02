import static org.junit.Assert.*;

import org.junit.Test;

public class IncreasingTripletSubsequence {
	public boolean increasingTriplet(int[] nums) {
		int max=Integer.MIN_VALUE,submax=Integer.MIN_VALUE;
		for(int i=nums.length-1; i>=0; i--) {
			if(max<=nums[i]) 
				max=nums[i];
			else if(submax<nums[i]) 
				submax=nums[i];
			else if(nums[i]<submax && max-submax>0)
				return true;
		}
		return false;
	}
	
	@Test
	public void test() {
		assertTrue(increasingTriplet(new int[] {5,1,5,5,2,5,4}));
		assertTrue(increasingTriplet(new int[] {1,2,3,4,5}));
		assertFalse(increasingTriplet(new int[] {5,4,3,2,1}));
	}
}
