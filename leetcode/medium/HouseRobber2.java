
public class HouseRobber2 {
	public int rob(int[] nums) {
		int n=nums.length;
		return Math.max(getMax(nums,0,n-1),getMax(nums,1,n));
	}
	private int getMax(int[]nums, int l,int r) {
		if(l==0 && l==r)return nums[l];
		int max=0;
		int pre1=0,pre2=0;
		for(int i=l;i<r;i++) {

			pre1=pre2;
			pre2=max;
			
			max=Math.max(pre1+nums[i], pre2);
		}
		return max;
	}
}
