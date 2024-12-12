package Tree;


import java.util.ArrayList;
import java.util.List;
public class FindMode {

    int count ;
    int maxCount;
    List<Integer> res;
    TreeNode pre;

    public int[] findMode(TreeNode root) {
        count = 0;
        maxCount = 0;
        pre = null;
        res = new ArrayList<>();
        find(root);
        //转为数组
        int[] mode = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            mode[i] = res.get(i);
        }
        return mode;
    }

    private  void find( TreeNode cur){
        if(cur == null )return;
        find(cur.leftChild);
        if(pre == null){
            count = 1;
        } else if (pre.val == cur.val) {
            count++;
        }else{
            count = 1;
        }
        pre = cur;
        if(count == maxCount) res.add(cur.val);
        if(count > maxCount){
            res.clear();
            maxCount = count;
            res.add(cur.val);
        }
        find(cur.rightChild);
    }
}