
public class HouseRobber {
	public int rob(int[] nums) {
		int max=0,pre=0,pre2=0;
		for(int n:nums){
			pre2=pre;
			pre=max;
			max=Math.max(max, pre2+n);
		}
		return max;
	}
}
