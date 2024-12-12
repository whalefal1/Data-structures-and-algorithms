package Tree;

public class InsertIntoBST {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null ){
            return  new TreeNode(val);
        }
        if(root.val < val){
            root.rightChild = insertIntoBST(root.rightChild,val);
        }else if(root.val > val){
            root.leftChild = insertIntoBST(root.leftChild,val);
        }
        return root;
    }
}
