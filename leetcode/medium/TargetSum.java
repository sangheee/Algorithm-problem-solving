import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;

public class TargetSum {

/*	public int findTargetSumWays(int[] nums, int S) {	
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
	*/
	public int findTargetSumWays(int[] nums, int S) {
		int sum=0;
		for(int n:nums)sum+=n;
		if(S>sum || S<-sum)return 0;
		int[]dp=new int[2*sum+1];
		dp[sum]=1;
		for(int i=0;i<nums.length;i++) {
			int[]next=new int[2*sum+1];
			for(int j=0; j<2*sum+1;j++) {
				if(dp[j]!=0) {
					next[j+nums[i]]+=dp[j];
					next[j-nums[i]]+=dp[j];
				}
			}
			dp=next;
		}
		return dp[sum+S];
	}
	@Test
	public void test() {
		assertEquals(findTargetSumWays(new int[] {1},2),0);
		assertEquals(findTargetSumWays(new int[] {1,1,1,1,1},3),5);
	}
}
