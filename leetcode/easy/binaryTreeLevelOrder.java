import java.util.*;

public class binaryTreeLevelOrder {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		helper(res,root,0);
		return res;
	}
	public void helper(List<List<Integer>> res,TreeNode root,int level){
		if(root==null)return;
		if(res.size()-1<level){
			res.add(0, new ArrayList<>());
		}
		res.get(res.size()-level-1).add(root.val);
		helper(res,root.left,level+1);
		helper(res,root.right,level+1);
	}
}
