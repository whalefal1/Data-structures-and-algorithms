package Arrays;

public class OrchestraLayout {


    public static void main(String[] args) {

        int num = 5;
        int xPos = 2;
        int yPos = 3;
        int result = orchestraLayout(num, xPos, yPos);
        System.out.println("The number at position (" + xPos + "," + yPos + ") is: " + result);
    }







    public static int orchestraLayout(int num, int xPos, int yPos) {
        int[][] grid = new int[num][num];
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 0; // 当前nums数组的索引

        int left = 0;
        int right = num - 1;
        int top = 0;
        int bottom = num - 1;

        while (left <= right && top <= bottom) {
            // 填充顶边：左到右
            for (int i = left; i <= right; i++) {
                grid[top][i] = nums[k % 9];
                k++;
            }
            top++;
            if (top > bottom) break;

            // 填充右边：上到下
            for (int i = top; i <= bottom; i++) {
                grid[i][right] = nums[k % 9];
                k++;
            }
            right--;
            if (left > right) break;

            // 填充底边：右到左
            for (int i = right; i >= left; i--) {
                grid[bottom][i] = nums[k % 9];
                k++;
            }
            bottom--;
            if (top > bottom) break;

            // 填充左边：下到上
            for (int i = bottom; i >= top; i--) {
                grid[i][left] = nums[k % 9];
                k++;
            }
            left++;
        }

        return grid[xPos][yPos];
    }
}
