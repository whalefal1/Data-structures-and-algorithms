package Tree;
import java.util.*;

/**
 * 二叉树的锯齿形水平遍历
 *
 * @author 李朋逊
 * @date 2023/05/26
 */
/*
                      line=1                                 0


                       line=2                     2                      4


                        line=3          1             null          3                  - 1

                        line=4    5       1                  null     6       null         8
                             -------------------------------------                 --------------------------------
                    even            4                 2                           odd                1
                             -------------------------------------                 --------------------------------

 */
public class ZigzagLevelOrder {
    public List<List<Integer> > solution(TreeNode root) {
    List<List<Integer> > resultList = new ArrayList<>();
        if(root == null){
            return resultList;
        }
        //因为遍历时的结果集顺序与层数有关：奇数层从左到右，偶数层从右到左，定义一个变量记录层数
        int level = 1;
        //定义两个双向队列来分别储存奇数与偶数层的元素
        Deque<TreeNode> odd = new LinkedList<>();
        Deque<TreeNode> even = new LinkedList<>();
        //队列初始化
        odd.offer(root);
        //遍历条件：因为每个树中元素都要遍历一遍，奇数层元素储存在odd队列，偶数层元素储存在even队列，所以当两队列都为空时，说明树中元素全部遍历
        while (!odd.isEmpty()||!even.isEmpty()){
            //定义结果集，用于储存每一层的元素
            List<Integer> result = new ArrayList<>();
            //获取奇偶队列的长度
            int oddLength = odd.size();
            int evenLength = even.size();
            //当长度不为0时，说明其中一个队列中存在元素，满足遍历条件
            while(oddLength>0||evenLength>0){
                //当为偶数层的情况
                if(level%2==0){
                    //偶数层元素储存在偶数队列中，偶数队列中的元素顺序与结果集元素顺序相同，但为了以便于遍历下一个奇数层元素，需要从对尾出队，添加到结果集中，此时结果集中元素与答案顺序相反，调用Collections的reverse接口翻转结果集即可
                    TreeNode temp = even.pollLast();
                    result.add(temp.val);
                    //因为偶数层从右向左，奇数层从左向右，则偶数层最后一个元素的左子树即为下一个奇数层的队首元素，先添加左子树，再添加右子树，依次遍历即可
                    if(temp.leftChild!=null){
                        odd.offer(temp.leftChild);
                    }
                    if(temp.rightChild!=null){
                        odd.offer(temp.rightChild);
                    }
                    evenLength--;
                }else {
                    //奇数层同理，注意同样是队尾出队，但先添加右子树，在添加左子树
                    TreeNode temp = odd.pollLast();
                    result.add(temp.val);
                    if(temp.rightChild!=null){
                        even.offer(temp.rightChild);
                    }
                    if(temp.leftChild!=null){
                        even.offer(temp.leftChild);
                    }
                    oddLength--;
                }
            }
            //对结果集的反转操作
            Collections.reverse(result);
            resultList.add(result);
            //对层操作
            level++;
        }
        return  resultList;
    }
}
