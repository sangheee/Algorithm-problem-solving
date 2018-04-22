
public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		if(root==null)return true;
	
		return dfs(root.left,Long.MIN_VALUE,root.val) && dfs(root.right,root.val,Long.MAX_VALUE);
	}

	private boolean dfs(TreeNode root, long min, long max) {
		if(root==null)return true;
		if(root.val>=max || root.val<=min)return false;
		 return dfs(root.left,min,root.val) && dfs(root.right,root.val,max);
	}
}
