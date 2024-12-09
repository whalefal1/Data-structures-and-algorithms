package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        getPath(res,new StringBuilder(),root);
        return res;
    }

    public void getPath(List<String> res,StringBuilder stringBuilder , TreeNode node){
        stringBuilder.append(node.val+"->");
        if(node.left == null && node.right == null) {
            res.add(stringBuilder.toString());
        }
        if(node.left!=null){
            getPath(res,stringBuilder,node.left);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
        if(node.right!=null){
            getPath(res,stringBuilder,node.right);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}
