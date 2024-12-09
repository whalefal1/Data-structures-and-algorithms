package Tree;

public class SumOfLeftLeaves {

    public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null) return 0;
        return sumOfLeftLeaves(root.left)
                + sumOfLeftLeaves(root.right)
                + (root.left!=null && root.left.left==null && root.left.right==null ? root.left.val : 0);
    }
}
