package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {
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
    public List<Integer> rightSideView(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        deque.offer(root);
        while(!deque.isEmpty()){
            int size = deque.size();
            TreeNode last = deque.pollLast();
            list.add(last.val);
            deque.offerLast(last);
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = deque.pollFirst();
                TreeNode left = treeNode.left;
                TreeNode right = treeNode.right;
                if(left!=null) deque.offerLast(left);
                if(right!=null) deque.offerLast(right);
            }
        }
        return list;
    }
}
