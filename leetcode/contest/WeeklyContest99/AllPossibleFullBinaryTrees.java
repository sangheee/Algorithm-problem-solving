package contest.WeeklyContest99;

import java.util.*;

public class AllPossibleFullBinaryTrees {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<TreeNode> allPossibleFBT(int N) {
        Map<Integer,List<TreeNode>> treeNodeMap=new HashMap<>();
        List<TreeNode> list=new ArrayList<>();
        list.add(new TreeNode(0));
        treeNodeMap.put(1,list);
        for (int i=3;i<=N; i+=2){
            list=new ArrayList<>();

            for (int j=1; j<i-1;j+=2){
                for (TreeNode leftnode:treeNodeMap.get(j)){
                    for (TreeNode rightnode:treeNodeMap.get(i-j-1)){
                        TreeNode root=new TreeNode(0);
                        root.left=leftnode;
                        root.right=rightnode;
                        list.add(root);
                    }
                }
            }
            treeNodeMap.put(i,list);
        }

        return treeNodeMap.getOrDefault(N,new ArrayList<>());
    }
}
