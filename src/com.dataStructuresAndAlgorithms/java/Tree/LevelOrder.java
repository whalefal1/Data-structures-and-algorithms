package Tree;

import ListCodes.ListNode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
  public class TreeNode {
      int val;
      LevelOrder.TreeNode left;
      LevelOrder.TreeNode right;

      TreeNode() {
      }

      TreeNode(int val) {
          this.val = val;
      }

      TreeNode(int val, LevelOrder.TreeNode left, LevelOrder.TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }

      public List<List<Integer>> levelOrder(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
          if(root == null) return result;
          Queue<TreeNode> queue = new LinkedList<>();
          queue.offer(root);
          while (!queue.isEmpty()) {
              List<Integer> list = new ArrayList<>();
              int size = queue.size();
              for (int i = 0; i < size; i++) {
                  TreeNode poll = queue.poll();
                  list.add(poll.val);
                  TreeNode left = poll.left;
                  TreeNode right = poll.right;
                  if (left != null) {
                      queue.offer(left);
                  }
                  if (right != null) {
                      queue.offer(right);
                  }
              }
              result.add(list);
          }
          return result;
      }
  }
}
