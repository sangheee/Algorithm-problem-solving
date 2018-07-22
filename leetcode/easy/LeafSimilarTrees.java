import java.util.*;

public class LeafSimilarTrees {
	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Queue<Integer> seq = new LinkedList<>();
		getLeaves(root1,seq);
		return isSimilar(root2,seq) && seq.isEmpty();
	}

	private boolean isSimilar(TreeNode root, Queue<Integer> seq) {
		if(root==null)return true;
		else if(root.left==null && root.right==null) {
			int v=seq.poll();
			return v==root.val;
		}
		if(!isSimilar(root.left,seq) || !isSimilar(root.right,seq))return false;
		return true;
	}

	private void getLeaves(TreeNode root,Queue<Integer> queue) {
		if(root==null)return;
		else if(root.left==null && root.right==null) {
			queue.add(root.val);
			return;
		}
		getLeaves(root.left,queue);
		getLeaves(root.right,queue);
	}
}
