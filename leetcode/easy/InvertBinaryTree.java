
public class InvertBinaryTree {
	public TreeNode invertTree(TreeNode root) {
		if(root==null)return root;
		TreeNode tmp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(tmp);
		return root;
	}
}
