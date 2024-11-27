package Tree;

public class HasPathSum {

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


    public boolean hasPathSum(TreeNode root, int targetSum) {
          if(root == null ) return false;
          if(targetSum == root.val){
                return true;
          }else{
              return hasPathSum(root.left,targetSum - root.val) && hasPathSum(root.right,targetSum - root.val);
          }
    }
}
