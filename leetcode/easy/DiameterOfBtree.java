
public class DiameterOfBtree {
	public int diameterOfBinaryTree(TreeNode root) {
		if(root==null)return 0;
		return Math.max(Math.max(diameterOfBinaryTree(root.left),diameterOfBinaryTree(root.right)), getDiameter(root.left,0)+getDiameter(root.right,0));
	}
	public int getDiameter(TreeNode root, int sum){
		if(root==null)return sum;
		return Math.max(getDiameter(root.left, sum+1),getDiameter(root.right, sum+1));
		
	}
}
