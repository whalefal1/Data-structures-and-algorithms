package Tree;

public class SumNumbers {
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
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    //再添加一个局部变量用于指示双亲节点的值
    public int dfs(TreeNode root, int prevSum) {

        if (root == null) {
            return 0;
        }
        //当前节点的值=双亲节点*10+当前节点的值
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }

}
