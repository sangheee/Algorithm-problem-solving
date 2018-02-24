import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Test;
public class HouseRobber3 {
	public int rob(TreeNode root) {
		int[] maxs=getMax(root,new int[2]);
		return Math.max(maxs[0], maxs[1]);
	}
	
	private int[] getMax(TreeNode root,int[]maxs) {
		if(root==null)return new int[2];
		
		int[]left=getMax(root.left,maxs);
		int[]right=getMax(root.right,maxs);
		int[] res=new int[2];
		res[0]=left[1]+right[1]+root.val;
		res[1]=Math.max(left[0], left[1])+Math.max(right[0], right[1]);
		return res;
	}
	
	@Test
	public void test() {
		TreeNode node=new TreeNode(4);
		node.left=new TreeNode(1);
		node.left.left=new TreeNode(2);
		node.left.left.left=new TreeNode(3);
		
		assertEquals(7,rob(node));
		
		
		node=new TreeNode(3);
		node.left=new TreeNode(4);
		node.right=new TreeNode(5);
		node.left.left=new TreeNode(1);
		node.left.right=new TreeNode(3);
		node.right.right=new TreeNode(1);
		
		assertEquals(9,rob(node));
		
		node=new TreeNode(2);
		node.left=new TreeNode(1);
		node.right=new TreeNode(3);
		node.left.right=new TreeNode(4);
		
		assertEquals(7,rob(node));

	}
}
