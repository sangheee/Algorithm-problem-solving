import java.util.*;
public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res= new ArrayList<>();
		getCombinationSum(candidates,res,new Stack<>(),candidates.length-1,target);
		return res;
	}

	private void getCombinationSum(int[] candidates,List<List<Integer>> res, Stack<Integer>cur, int idx, int target) {
		if(target==0) {
			res.add(new ArrayList<>(cur));
			return;
		}else if(target<0)
			return;
		else {
			for(int i=idx;i>=0;i--) {
				int val=candidates[i];
				cur.push(val);
				getCombinationSum(candidates,res,cur,i,target-val);
				cur.pop();
			}
		}
	}
}
