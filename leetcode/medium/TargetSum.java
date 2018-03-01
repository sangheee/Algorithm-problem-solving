import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class TargetSum {

	public int findTargetSumWays(int[] nums, int S) {	
		int step=0;
		
		Map<Integer,Integer>cnt=new HashMap<>();
		cnt.put(0, 1);
		while(step<nums.length) {
			Map<Integer,Integer> newCnt=new HashMap<>();
			for(int key:cnt.keySet()) {
				int v=newCnt.getOrDefault(key+nums[step], 0);
				newCnt.put(key+nums[step],cnt.get(key)+v);
				v=newCnt.getOrDefault(key-nums[step], 0);
				newCnt.put(key-nums[step], cnt.get(key)+v);
			}
			cnt=newCnt;
			step++;
		}
		return cnt.getOrDefault(S, 0);		
	}
	@Test
	public void test() {
		//assertEquals(findTargetSumWays(new int[] {1},2),0);
		assertEquals(findTargetSumWays(new int[] {1,1,1,1,1},3),5);
	}
}
