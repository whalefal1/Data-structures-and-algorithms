package Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Flatten {
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
    List<TreeNode> list = new ArrayList<>();
    //二叉树转单链表
    public void flatten(TreeNode root) {
        preSort(root);
        int size = list.size();
        for (int i = 1; i < size; i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.left = null;
            pre.right = cur;
        }
    }

    //二叉树的前序遍历+集合存储节点元素

    public void preSort(TreeNode root){
        if(root !=null){
            list.add(root);
            preSort(root.left);
            preSort(root.right);
        }
    }
 }
