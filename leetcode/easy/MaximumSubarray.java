
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		long max=Integer.MIN_VALUE;
        long prep=Integer.MIN_VALUE;

		for(int n:nums){
            prep=Math.max(n, prep+n);
			max=Math.max(max, prep);
		}
		return (int)max;
	}
}
