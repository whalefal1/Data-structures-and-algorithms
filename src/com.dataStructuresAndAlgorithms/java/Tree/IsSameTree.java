package Tree;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p != q){
            return false;
        }else{
            return isSameTree(p.leftChild!=null?p.leftChild:null,q.leftChild!=null?q.leftChild:null) &&  isSameTree(p.rightChild!=null?p.rightChild:null,q.rightChild!=null?q.rightChild:null) ;
        }
    }
}
