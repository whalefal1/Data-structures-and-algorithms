package Tree;

import com.sun.source.tree.Tree;

import java.awt.event.TextEvent;

public class MaxDepth {



      public static class TreeNode {
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

        public static int maxDepth(TreeNode root) {
               return Math.max(root.left!=null?maxDepth(root.left) + 1:1,root.right!=null?maxDepth(root.right) + 1:1);
        }



    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2  = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        root.left = t1;
        root.right = t2;
        t2.left = t3;
        t2.right = t4;
        System.out.println(maxDepth(root));
    }
}
