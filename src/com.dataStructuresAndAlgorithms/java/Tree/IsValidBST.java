package Tree;

import com.sun.source.tree.Tree;

public class IsValidBST {

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

 //如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值； 若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树
 //
 //作者：力扣官方题解
 //链接：https://leetcode.cn/problems/validate-binary-search-tree/solutions/230256/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
 //来源：力扣（LeetCode）
 //著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //upper标识左子树中节点的最大值
    //lower表示右子树中节点的最小值
    //所以我们比较的时候是按树节点的值与所在子树的最值并进行比较，并不仅仅是按照根节点与左右子树进行比较
    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
