package Tree;



import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉搜索树
 *              4
 *        /         \
 *      2             7
 *   /    \        /   \
 * 1        3    6      8
 *               /
 *             5
 * @author 李朋逊
 * @date 2023/05/23
 */
public class BinarySearchTree {

    static class BSTNode{
        //键
        int key;
        //值
        Object value;
        //左右节点
        BSTNode left;
        BSTNode right;

        public BSTNode(int ket) {
            this.key = ket;
        }

        public BSTNode(int key, Object value, BSTNode left, BSTNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public BSTNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    //创建根节点
    BSTNode root;


    /**
     * Description 根据节点的键获取节点值
     *
     * @param key 关键
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/23
     */
    public Object get(int key) {
        //非递归方法
        /*return doGet(root,key);*/
        BSTNode node = root;
        while(node!=null){
            if(node.key<key){
                node = node.right;
            } else if (node.key>key) {
                node = node.left;
            }else{
                return node.value;
            }
        }
        return null;
    }
    //递归方法
    private Object doGet(BSTNode node,int key){
        if(node == null){
            return null;
        }
        if(key<node.key){
            return  doGet(node.left,key);
        }else if(key>node.key){
            return doGet(node.right,key);
        }else{
            return node.value;
        }
    }


    /**
     * Description 获取最小节点值
     *
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/23
     */
    public Object min(){
        /*return doMin(root);*/
       //非递归方法
        BSTNode node = root;
        if(node == null){
            return null;
        }
        while(node.left!=null){
            node = node.left;
        }
        return node.value;
    }

    //递归方法
    private Object doMin(BSTNode node){
        if(node == null){
            return null;
        }
        if(node.left == null){
            return node.value;
        }
        return doMin(node.left);
    }


    /**
     * Description 获取最大节点的值
     *
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/24
     */
    public  Object max(){
        /*return doMax(root);*/
       //非递归方法
        BSTNode node = root;
        if(node == null){
            return null;
        }
        while(node.right!=null){
            node = node.right;
        }
        return node.value;
    }
    //递归方法
    private Object doMax(BSTNode node){
        if(node == null){
            return null;
        }
        if(node.right == null){
            return node.value;
        }
        return doMin(node.right);
    }


    /**
     * Description 存储关键字与对应值
     *
     * @param key   键
     * @param value 值
     * @author 李朋逊
     * @date 2023/05/24
     */
    public void put(int key,Object value){
        //1.key存在，更新
        //2.key不存在，新增
        BSTNode node = root;
        //用于存放每次新增的父节点
        BSTNode parent = null;
        while(node!=null){
            parent = node;
            if(node.key<key){
                node = node.right;
            } else if (node.key>key) {
                node = node.left;
            }else{
                //节点存在，更新
                node.value = value;
                return ;
            }
        }
        //当循环完成之后，说明树中不存在节点的key，此时parent指针指向的是树的某一个叶子节点
        //当parent为空时，说明树为空，则新增节点为root节点
        //节点不存在，则需要新节点与parent节点比较，若key小于parent.key，则新增节点为parent节点的左节点，若key大于parent.key,则新增节点为parent的右节点
        if(parent == null){
            root = new BSTNode(key,value);
        }
        if(parent.key>key){
            parent.left = new BSTNode(key,value);
        }else if(parent.key<key){
            parent.right = new BSTNode(key,value);
        }
    }

    /**
     * Description 查找关键字的后继
     *
     * @param key 键
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/24
     */
    public Object successor(int key){
        BSTNode node = root;
        BSTNode ancestor = null;
        while(node!=null){
            if(key< node.key){
                ancestor = node;
                node = node.left;
            } else if (key> node.key) {
                node = node.right;
            }else{
                break;
            }
        }
        if(node == null){
            return null;
        }
        if(node.right!=null){
            return doMax(node.right);
        }
        return ancestor!=null ? ancestor.value : null;
    }

    /**
     * Description 查找关键字的前驱
     *
     * @param key 键
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/24
     */
    public Object predecessor(int key){
        //规律：1.若当前节点存在左子树，则当前节点的前任为左子树的最大值
        //          2.若当前节点不存在左子树，则前驱为当前节点的从左而来的最近的祖先节点
        BSTNode node = root;
        //用于记录当前节点从左而来的祖先节点：当key>node.key时，说明当前节点为父节点的右子树，则当前节点的从左而来的最近的祖先节点为当前节点的父节点
        BSTNode ancestor = null;
        while(node!=null){
            if (key<node.key){
                node = node.left;
            } else if (key>node.key) {
                //当满足条件时，祖先节点更新为当前节点的父节点，否则就一直记录祖先节点
                ancestor = node;
                node = node.right;
            }else{
                break;
            }
        }
        //未找到节点
        if(node == null){
            return null;
        }
        //当前节点存在左子树，找左子树的最大值
        if(node.left!=null){
            return doMax(node.left);
        }
        //当前节点不存在左子树，找从左而来的最近的祖先节点，祖先节点不为空，直接返回，祖先节点为空，返回空
        return ancestor != null  ?  ancestor.value  :  null;
    }


    /**
     * Description 根据键删除节点
     *
     * @param key 键
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/05/24
     */
    public Object delete(int key){
       /*
       1.删除的节点没有左孩子，则将右孩子托孤给父节点
       2.删除的节点没有右孩子，则将左孩子托孤给父节点
       3.被删除节点为叶子节点，没有左右子树，直接把null托孤给parent
       4.
        */
        BSTNode node = root;
        //用于记录删除节点的父节点，注意不能放在if判断之外
        BSTNode parent = null;
        while(node!=null){
            //注意此时parent变量赋值的位置
            if(key< node.key){
                parent = node;
                node = node.left;
            } else if (key> node.key) {
                parent = node;
                node = node.right;
            }else {
                break;
            }
        }
        if(node == null){
            return null;
        }
        if(node.left == null){
            shift(parent,node,node.right);
        }else if(node.right == null){
            shift(parent,node,node.left);
        }else {
            //使用后继节点的原因：保证二叉搜索树的性质
            //被删除节点左右孩子都有，可以将他的后继节点（S）托孤给父节点（Parent），再称S的父亲为SP
            //1.SP为被删除节点，说明被删除节点与后继节点紧邻，则只需要将S托孤给父节点
            //2.SP不是被删除的节点，说明被删除的节点与后继节点不相邻，则需要将S的后代托孤给SP，再将S托孤给被删除节点的父节点（Parent）
            //找到后继节点
            BSTNode successor = node.right;
            BSTNode SParent = node;
              while(successor.left!=null){
                  SParent = successor;
                  successor = successor.left;
              }
              //删除节点与后继节点不相邻，处理后继节点的子孙
            if(SParent != node){
                //注意：后继节点为被删除节点右子树的最小值，所以后继节点不可能存在左孩子，否则后继节点不为最小的右子树节点
                shift(SParent,successor,successor.right);
                //改变后继节点的右子树
                successor.right = node.right;
            }
            //后继节点取代被删除节点
            shift(parent,node,successor);
            //改变后继节点的左子树
            successor.left = node.left;
        }


        return node.value;
    }


    /**
     * Description 转变
     *
     * @param parent  被删除节点的父节点
     * @param deleted 被删除节点
     * @param child   被删除节点的子孙节点
     * @author 李朋逊
     * @date 2023/05/25
     */
    private void shift(BSTNode parent,BSTNode deleted,BSTNode child){
      if(parent == null){
          root = child;
      } else if (deleted == parent.left) {
          parent.left = child;
      } else if (deleted == parent.right) {
          parent.right = child;
      }
    }


    /**
     * Description
     *删除方法的递归实现——数属于广义表，递归方法一般使用递归实现
     * @param key
     * @param root
     * @return {@link Object }
     * @author 李朋逊
     * @date 2023/10/26
     */
    public BSTNode delete(int key,BSTNode root){
        if(root == null) return null;
        if(key<root.key){
            root.left = delete(key, root.left);
            return root;
        }
        if(key>root.key){
            root.right = delete(key, root.right);
            return root;
        }
        //表示找到了要删除的节点
        //情况1
        if(root.left == null){
            return root.right;
        }
        //情况2
        if(root.right == null){
            return root.left;
        }
        //情况4
        BSTNode minNode = root.right;
        while(minNode.left!=null){
            minNode = minNode.left;
        }
        minNode.left = root.left;


        return root;
    }
    /**
     * Description
     *找小于key的所有value——中序遍历
     * @param key
     * @return {@link List }<{@link Object }>
     * @author 李朋逊
     * @date 2023/10/26
     */
    public List<Object>  less(int key){
        ArrayList<Object> result = new ArrayList<>();
        BSTNode p = root;
        LinkedList<BSTNode> stack = new LinkedList<>();
        while(p != null || stack.isEmpty()){
            if(p != null){
                stack.push(p);
                p = p.left;
            }else{
                BSTNode node = stack.pop();
                p = node.right;
            }
        }
        return result;
    }

}
