package Tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/*
层序遍历
返回值形式
[
    [1]
    [2,3]
    [4,5,6,7]
    ]
 */
public class LevelTraverse {
    public List<List<Integer>> leveTraverse(TreeNode root){
        List<List<Integer>> resultList = new ArrayList<>();
        solution(root,resultList);
        return resultList;
    }
    //队列法
    public void solution(TreeNode root,List<List<Integer>> resultList){
        if(root == null){
            return;
        }
        //定义结果队列，并存入根节点
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //循环条件为队列不为空，保证所有树元素都能被遍历到
        while(!queue.isEmpty()){
            //定义一个集合用于储存每一层的树元素
            List<Integer> result = new ArrayList<>();
            //注意：length表示队列元素的数量
            int length = queue.size();
            while(length>0){
                //将队列中的队首元素取出
                TreeNode temp = queue.poll();
                //将队首元素添加到队列中
                result.add(temp.val);
                //判断队首元素是否存在左子树，若存在，则左子树入队
                if(temp.leftChild!=null){
                    queue.offer(temp.leftChild);
                }
                //判断队首元素是否存在右子树，若存在，则右子树入队
                if(temp.rightChild!=null){
                    queue.offer(temp.rightChild);
                }
                //因为集合中已经存入一个树元素，则length--保证循环结束条件
                length--;
            }
            resultList.add(result);
        }
    }
}
