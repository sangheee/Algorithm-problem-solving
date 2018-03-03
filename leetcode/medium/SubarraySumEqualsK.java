import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Test;

public class SubarraySumEqualsK {
	/*public int subarraySum(int[] nums, int k) {
		int n=nums.length;
		int[]preSum=new int[n+1];
		Map<Integer,Integer> appear=new HashMap<>();
		for(int i=0;i<n;i++)preSum[i+1]=preSum[i]+nums[i];
		int[] preSum2=new int[n+1];
		for(int i=0;i<n+1;i++)preSum2[i]=preSum[i]-k;
		int res=0;
		for(int i=0;i<n+1;i++) {
			if(appear.containsKey(preSum2[i]))res+=appear.get(preSum2[i]);
			int v=appear.getOrDefault(preSum[i], 0);
			appear.put(preSum[i], v+1);
		}
		return res;
	}*/
	public int subarraySum(int[] nums, int k) {
		int res=0;
		Map<Integer,Integer>preSum=new HashMap<>();
		preSum.put(0, 1);
		int sum=0;
		for(int n:nums) {
			sum+=n;
			if(preSum.containsKey(sum-k))res+=preSum.get(sum-k);
			int v=preSum.getOrDefault(sum, 0);
			preSum.put(sum, v+1);
		}
		
		return res;
	}
	@Test
	public void test() {
		assertEquals(7,subarraySum(new int[] {1,1,1,1,1,-1,-1,1},2));
		assertEquals(5,subarraySum(new int[] {1,1,1,1,1,1},2));
	}
}
