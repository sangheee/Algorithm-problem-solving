
public class MajorityElement {
	public int majorityElement(int[] nums) {
		int cnt=0;
		int major=nums[0];
		for(int n: nums){
			if(cnt==0)major=n;
			cnt+=major==n?1:-1;
		}
		return major;
	}
}
