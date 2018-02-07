public class SortColors {
	public void sortColors(int[] nums) {
		int l=0,r=nums.length-1,m=0;
		while(m<=r) {
			if(nums[m]==0) {
				swap(nums,l,m);
				m++;
				l++;
			}else if(nums[m]==1) {
				m++;
			}else{
				swap(nums,m,r);
				r--;
			}
		}
	}
	public void swap(int[] nums, int i, int j) {
		int tmp=nums[i];
		nums[i]=nums[j];
		nums[j]=tmp;
	}
}
