import java.util.*;

public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res=new ArrayList<>();
		travel(root,res,0);
		return res;
	}
	public void travel(TreeNode root, List<List<Integer>> res,int level) {
		if(root==null)return;
		if(res.size()<level+1)res.add(new ArrayList<>());
		res.get(level).add(root.val);
		travel(root.left,res,level+1);
		travel(root.right,res,level+1);
	}
}
