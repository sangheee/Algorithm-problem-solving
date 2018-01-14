
public class PathSum3 {
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathSumUtil(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
	}

	public int pathSumUtil(TreeNode root, int target) {
		if (root == null)
			return 0;
		return (root.val == target ? 1 : 0) + pathSumUtil(root.left, target - root.val)
				+ pathSumUtil(root.right, target - root.val);
	}
}
