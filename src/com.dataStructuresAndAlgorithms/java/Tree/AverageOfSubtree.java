package Tree;

public class AverageOfSubtree {
    public static class TreeNode {
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

    public static void main(String[] args) {


        TreeNode root = new TreeNode(4);
        TreeNode left = new TreeNode(8);
        TreeNode right = new TreeNode(5);
        TreeNode left1 = new TreeNode(0);
        TreeNode right1 = new TreeNode(1);
        TreeNode right2 = new TreeNode(6);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = right1;
        right.right = right2;
        AverageOfSubtree averageOfSubtree = new AverageOfSubtree();
        int result = averageOfSubtree.averageOfSubtree(root);
        System.out.println(result);
    }

    int cnt;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return cnt;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{0, 0};

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int sum = (l[0] + r[0] + root.val), nodeNum = (l[1] + r[1] + 1), avg = sum / nodeNum;
        if (avg == root.val) cnt++;
        return new int[]{sum, nodeNum};
    }
}

