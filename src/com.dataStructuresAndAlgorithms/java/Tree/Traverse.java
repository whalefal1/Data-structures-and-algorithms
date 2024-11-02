package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traverse {

    /*
    前序遍历——递归方法
     */
    public List<Integer> preOrderTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preOrder(root,result);
        return result;
    }
    public void preOrder(TreeNode root,List<Integer> result){
        if(root==null){
            return;
        }
        //result.add()方法最先调用
        result.add(root.val);
        preOrder(root.leftChild,result);
        preOrder(root.rightChild,result);
    }

    /*
    中序遍历——递归方法
     */
    public List<Integer> inOrderTraverse(TreeNode root){
            List<Integer> result = new ArrayList<>();
            inOrder(root,result);
            return result;
    }
    public void inOrder(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        inOrder(root.leftChild,result);
        //result.add()方法在中间调用
        result.add(root.val);
        inOrder(root.rightChild,result);
    }

    /*
    后序遍历——递归方法
     */
    public List<Integer> postOrderTraverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        postOrder(root,result);
        return result;
    }
    public void postOrder(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        postOrder(root.leftChild,result);
        postOrder(root.rightChild,result);
        //result.add()方法最后调用
        result.add(root.val);
    }

    /*
    前序遍历——递推法  栈实现
     */
    public List<Integer> preTraverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            //栈顶元素出栈存入result集合
            TreeNode node = stack.pop();
            result.add(node.val);
            //注意：栈是先入后出，所以要右子树先入栈，左子树再入栈，这样在出栈存入集合时才满足中——左——右顺序
            //若右子树不为空，入栈
            if(node.rightChild != null){
                stack.push(node.rightChild);
            }
            //若左子树不为空，入栈
            if(node.leftChild != null){
                stack.push(node.leftChild);
            }
        }
        return result;
    }

    /*
    中序遍历——递推法   栈+指针
     */
    public List<Integer> inTraverse(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack();
        //定义指针
        TreeNode cur = root;
        //注意循环条件：当指针指向的节点存在或栈不为空时，循环执行
        //指针指向的节点存在：因为中序遍历是从最左侧的一个没有左子树的节点开始的，首先要找到这个节点，所以要定义指针cur，不断将cur指向左子树，找到遍历开始的节点
        while(cur!=null||!stack.isEmpty()){
            //若不为空，则说明cur还存在左子树，则可将cur继续移动，在移动的过程中将指向的节点元素入栈
            if(cur!=null){
                stack.push(cur);
                cur = cur.leftChild;
            }else{
                //若为空，则说明cur不再存在左子树，则可将此节点元素储存到集合中，并将cur指向其右右子树
                //若右子树存在，则继续存入栈中并判断，若不存在，则继续提出栈内元素，并将cur指向栈顶元素，以便判断已遍历过的元素是否存在右子树
                cur = stack.pop();
                result.add(cur.val);
                cur = cur.rightChild;
            }
        }
        return result;
    }
    /*
    后序遍历——递推        法  前序遍历+翻转
     */

    public List<Integer> postTraverse(TreeNode root){
            List<Integer> result = new ArrayList<>();
            if (root == null){
                return result;
            }
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while (!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if (node.leftChild != null){
                    stack.push(node.leftChild);
                }
                if (node.rightChild != null){
                    stack.push(node.rightChild);
                }
            }
            Collections.reverse(result);
            return result;
    }
}
