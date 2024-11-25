package Tree;


import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 *
 * @author 李朋逊
 * @date 2023/05/26
 */
public class IsSymmetric {
    //递归方法
    public  boolean solution1(TreeNode root){
        return check(root,root);
    }
    public boolean check(TreeNode left,TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && check(left.leftChild, right.rightChild) && check(left.rightChild, right.leftChild);
    }

    //递推方法——使用双向队列：左子树从队首进入，从队首出；右子树从队尾进入，从对尾出，需要注意入队顺序
    /*
            -------------------------                         ------------------------------------------------------------------------------
            left  right                                            left.leftChild  left.rightChild  right.rightChild  right.leftChild
            -------------------------                         ------------------------------------------------------------------------------
     */
    public boolean solution2(TreeNode root){
        if(root == null){
            return false;
        }
        //初始化队列
        Deque<TreeNode> deque = new LinkedList();
        deque.offerFirst(root.leftChild);
        deque.offerLast(root.rightChild);
        while(!deque.isEmpty()){
            //两指针分别指向被取出的队首元素与队尾元素
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            //若两指针指向都为空，说明该对节点为叶子节点，需要继续进行循环，直接continue
            if(left == null && right == null){
                continue;
            }
            //不成立的情况判断：两指针有一个为空或两指针指向元素不相等，直接返回false
            if(left == null ||right == null || left.val != right.val){
                return false;
            }
            //将左右子节点的子孙入队，保证循环运行，注意入队顺序
            deque.offerFirst(left.leftChild);
            deque.offerFirst(left.rightChild);
            deque.offerLast(right.rightChild);
            deque.offerLast(right.leftChild);
        }
        return true;
    }
}
