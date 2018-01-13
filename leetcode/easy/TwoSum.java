import java.util.*;

import org.junit.Test;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer,Integer> diffMap=new HashMap<>();
		
		for(int i=0; i<nums.length;i++){
			if(diffMap.containsKey(nums[i]))return new int[]{diffMap.get(nums[i]),i};
            int diff=target-nums[i];
			diffMap.put(diff, i);
		}
		return null;
	}
}
