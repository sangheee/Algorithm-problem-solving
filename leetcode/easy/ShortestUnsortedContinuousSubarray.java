public class ShortestUnsortedContinuousSubarray {
	public int findUnsortedSubarray(int[] nums) {
		int l=-1,r=0;
		int max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
		for(int i=0; i<nums.length;i++){
			max=Math.max(max, nums[i]);
			l=max>nums[i]?i:l;
		}
		
		for(int j=nums.length;j>=0;j--){
			min=Math.min(min, nums[j]);
			r=min<nums[j]?j:r;
		}
		
		return l-r+1;
	}
}
