
public class BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
		return root=dfs(root);
	}
	private TreeNode dfs(TreeNode root) {
		if(root==null)return null;
	
		root.left=dfs(root.left);
		root.right=dfs(root.right);
		
		
		if(root.left==null && root.right==null&&root.val==0) {
			return null;
		}
		return root;
	}

}
