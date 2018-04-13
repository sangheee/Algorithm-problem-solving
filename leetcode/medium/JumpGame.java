import static org.junit.Assert.*;
import org.junit.Test;

public class JumpGame {
/*	public boolean canJump(int[] nums) {
		boolean res=true;
		int hop=1;
		for(int i=nums.length-2;i>=0;i--) {
			if(nums[i]>=hop) {
				res=true;
				hop=1;
			}else {
				res=false;
				hop++;
			}
		}
		return res;
	}
	*/
	public boolean canJump(int[] nums) {
		int lastPos=nums.length-1;
		for(int i=nums.length-1;i>=0;i--) {
			if(i+nums[i]>=lastPos) {
				lastPos=i;
			}
		}
		return lastPos==0;
	}
	@Test
	public void test() {
		assertTrue(canJump(new int[] {2,3,1,1,3}));
		assertFalse(canJump(new int[] {3,2,1,0,4}));
	}
}
