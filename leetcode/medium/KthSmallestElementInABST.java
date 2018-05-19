import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthSmallestElementInABST {
	private int cur;
	private int ret;
	public int kthSmallest(TreeNode root, int k) {
		cur=0;
		ret=0;
		calKthSmallest(root,k);
		return ret;
	}

	private void calKthSmallest(TreeNode root,int k) {
		if(root==null ||ret!=0)return ;
		if(cur==k) {ret=root.val;return;}
		calKthSmallest(root.left,k);
		if(++cur==k){ret=root.val;return;}
		calKthSmallest(root.right,k);
	}
	
	@Test
	public void test() {
		TreeNode root=new TreeNode(5);
		root.left=new TreeNode(3);
		root.right=new TreeNode(6);
		root.left.left=new TreeNode(2);
		root.left.right=new TreeNode(4);
		root.left.left.left=new TreeNode(1);
		assertEquals(kthSmallest(root,1),1);
		assertEquals(kthSmallest(root,3),3);
		assertEquals(kthSmallest(root,4),4);
	}
}
