
public class ConvertBSTtoGreatTree {
	public TreeNode convertBST(TreeNode root) {
		makeGreatTree(root,0);
		return root;
	}
	public int makeGreatTree(TreeNode root, int val){
		if(root==null)return 0;
		if(root.left==null && root.right==null)return root.val=root.val+val;

		root.val+=root.right==null?val:makeGreatTree(root.right,val);	
		return root.left==null?root.val:makeGreatTree(root.left,root.val);
	}
}
