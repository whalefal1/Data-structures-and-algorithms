package Tree;

import java.util.ArrayList;
import java.util.List;
/*
实现二叉树
 */
public class MyTree {
  //树节点类
  static class TreeNode {
    int value;
    TreeNode leftChild;
    TreeNode rightChild;

    public TreeNode() {
    }

    public TreeNode(int value) {
      this.value = value;
      this.leftChild = null;
      this.rightChild = null;
    }
  }

  TreeNode root;
  //实例化方法
  public MyTree(TreeNode root) {
    this.root = root;
  }
  /*
  判断节点是否存在
  若存在，则返回true，若不存在，则返回false
   */
  public boolean isExist(TreeNode target){
    List<TreeNode> list = new ArrayList<>();
    list = preOrderTraverse(root,list);
    boolean flag  = false;
    for (int i = 0; i < list.size(); i++) {
      if(target == list.get(i)){
        flag = true;
      }
    }
    return flag;
  }
/*
添加左子树
参数：target：目标节点   value： 要添加的左子树
 若添加成功，则返回true，失败则返回false；
 */
  public boolean addAsLeftChild(TreeNode target,TreeNode value) {
      if (target.leftChild != null || value == null || target.leftChild!=null) {
        return false;
      }
      TreeNode leftChild = value;
      target.leftChild = leftChild;
      return true;
  }
/*
添加右子树
参数：target：目标节点   value： 要添加的右子树
 若添加成功，则返回true，失败则返回false；
 */
  public boolean addAsRightChild(TreeNode target, TreeNode value) {
    if (target == null || value == null || target.rightChild != null) {
      return false;
    }
      TreeNode rightChild = value;
      target.rightChild = rightChild;
    return true;
  }
/*
前序遍历
返回树节点集合
 */
  public List<TreeNode> preOrderTraverse(TreeNode root,List<TreeNode> list) {
    if (root == null) {
      return list;
    }
    list.add(root);
    preOrderTraverse(root.leftChild,list);
    preOrderTraverse(root.rightChild,list);
    return list;
  }
  /*
  中序遍历
  返回树节点集合
   */
  public List<TreeNode> inOrderTraverse(TreeNode root,List<TreeNode> list) {
    if (root == null) {
      return list;
    }
    inOrderTraverse(root.leftChild,list);
    list.add(root);
    inOrderTraverse(root.rightChild,list);
    return list;
  }
  /*
  后序遍历
  返回树节点集合
   */
  public List<TreeNode> postOrderTraverse(TreeNode root,List<TreeNode> list) {
    if (root == null) {
      return list;
    }
    list.add(root);
    postOrderTraverse(root.leftChild,list);
    postOrderTraverse(root.rightChild,list);
    return list;
  }
  /*
  获取某节点的双亲节点
   */
  public TreeNode getParent(TreeNode child){
    TreeNode node = new TreeNode();
    if(child == null){
      return node;
    }
    if(!isExist(child)){
      return null;
    }else{
      List<TreeNode> list = new ArrayList<>();
      list = preOrderTraverse(root,list);
      for (int i = 0; i < list.size(); i++) {
        if(list.get(i).leftChild == child || list.get(i).rightChild == child){
          node = list.get(i);
        }
      }
    }
    return node;
  }
/*
获取某节点的子节点
 */
  public List<TreeNode> getChild(TreeNode  target){
    List<TreeNode> list = new ArrayList<>();
    if (target == null){
      return list;
    }
    if(isExist(target)){
      list.add(target.leftChild);
      list.add(target.rightChild);
    }
    return list;
  }
/*
获取叶子节点
 */
  public List<TreeNode> getLeaves(){
    List<TreeNode> result = new ArrayList<>();
    List<TreeNode> list = new ArrayList<>();
    list = preOrderTraverse(root,list);
    for (int i = 0; i < list.size(); i++) {
      if(list.get(i).leftChild == null && list.get(i).rightChild == null){
        result.add(list.get(i));
      }
    }
    return result;
  }
}
