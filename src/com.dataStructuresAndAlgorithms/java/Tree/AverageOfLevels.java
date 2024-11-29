package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageOfLevels {
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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0 ;
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                sum+=poll.val;
                TreeNode left = poll.left;
                TreeNode right = poll.right;
                if(left != null){
                    queue.offer(left);
                }
                if(right != null){
                    queue.offer(right);
                }
            }
            result.add(sum/size);
        }
        return result;
    }
}
