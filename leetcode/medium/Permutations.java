import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret=new ArrayList<>();
		LinkedList<Integer> list=new LinkedList<>();
		for(int n:nums)list.add(n);
		getPermute(ret,list,new ArrayList<>());
		return ret;
	}
	public void getPermute(List<List<Integer>> ret, LinkedList<Integer> nums,List<Integer> cur) {
		if(nums.isEmpty()) {
			ret.add(new ArrayList<>(cur));
			return;
		}
		
		for(int i=0; i<nums.size();i++) {
			int val=nums.get(i);
			nums.remove(i);
			cur.add(val);
			
			getPermute(ret,nums,cur);
			nums.add(i, val);
			cur.remove(cur.size()-1);
		}
	}
}
