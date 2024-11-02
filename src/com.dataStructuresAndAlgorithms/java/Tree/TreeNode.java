package Tree;

import java.util.*;

public class TreeNode {
    int val;
      TreeNode leftChild;
     TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode leftChild, TreeNode rightChild) {
        this.val = val;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }
}
