
public class ConvertBSTtoGreatTree {
	public TreeNode convertBST(TreeNode root) {
		makeGreatTree(root,0);
		return root;
	}
	public int makeGreatTree(TreeNode root, int val){
		if(root==null)return val;
		
		root.val+=makeGreatTree(root.right,val);
		return makeGreatTree(root.left,root.val);
	}
}
