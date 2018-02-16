import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret=new ArrayList<>();
		getSubsets(ret,new ArrayList<>(),nums,0);
		return ret;
	}

	private void getSubsets(List<List<Integer>> ret, List<Integer> temp, int[] nums, int i) {
		if(i==nums.length)return;
		ret.add(new ArrayList<>(temp));
		
		for(int j=i;j<nums.length;j++) {
			temp.add(nums[j]);
			getSubsets(ret,temp,nums,j+1);
			temp.remove(temp.size()-1);
		}
	}
}
