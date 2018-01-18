
public class DiameterOfBtree {
	public int diameterOfBinaryTree(TreeNode root) {
		getDiameter(root);
		return max;
	}
	private int max=0;
	public int getDiameter(TreeNode root){
		if(root==null)return 0;
		int left=getDiameter(root.left);
		int right=getDiameter(root.right);
		int sum=Math.max(left, right);
		max=Math.max(max, left+right);
		return sum+1;
	}
}
