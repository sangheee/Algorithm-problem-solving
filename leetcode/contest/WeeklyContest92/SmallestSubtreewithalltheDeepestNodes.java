
public class SmallestSubtreewithalltheDeepestNodes {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	class Pair<L,R>{
		final L left;
		final R right;
		public Pair(L left,R right) {
			this.left = left;
	        this.right = right;
		}
	}
	public TreeNode subtreeWithAllDeepest(TreeNode root) {
		return dfs(root,0).left;
	}
	private Pair<TreeNode,Integer> dfs(TreeNode root,int depth) {
		if(root==null)return new Pair<TreeNode,Integer>(null,depth); 
				
		Pair<TreeNode,Integer> left=dfs(root.left,depth+1);
		Pair<TreeNode,Integer> right=dfs(root.right,depth+1);
		if(left.right==right.right)return new Pair<TreeNode, Integer>(root,left.right);
		return left.right>right.right?left:right;
	}
}
