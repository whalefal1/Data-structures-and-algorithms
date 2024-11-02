package Tree;

import java.util.LinkedList;
import java.util.Queue;
//翻转二叉树
public class InvertTree {
    public TreeNode solution(TreeNode root){
        if(root == null){
            return null;
        }
        //定义队列，便于遍历
        Queue<TreeNode> queue = new LinkedList<>();
        while(!queue.isEmpty()){
            //每次获取队列首元素
            TreeNode cur = queue.poll();
            //将左右子树交换
                TreeNode temp = cur.leftChild;
                cur.leftChild = cur.rightChild;
                cur.rightChild = temp;
                //若存在左子树，将左子树添加到队列中
                if(cur.leftChild!=null)
                queue.offer(cur.leftChild);
                //若存在右子树，则将右子树添加到队列中
                if(cur.rightChild!=null)
                queue.offer(cur.rightChild);
        }
        return root;
    }
    public TreeNode solution1(TreeNode root){
        //递推结束条件
        if(root == null){
            return null;
        }
        solution(root.leftChild);
        solution(root.rightChild);
        //交换左右子树
        TreeNode temp = root.leftChild;
        root.leftChild = root.rightChild;
        root.rightChild = temp;
        return root;
    }
}
