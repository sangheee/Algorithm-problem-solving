import java.util.*;

public class FindAllNumbersDisappearedInAnArray {
	public List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<>();
		for(int i=0; i<nums.length;i++){
			int n=Math.abs(nums[i])-1;
			if(nums[n]>0)nums[n]=-nums[n];
		}
		for(int i=0; i<nums.length;i++)
			if(nums[i]>0)result.add(i+1);
		return result;
	}
}
