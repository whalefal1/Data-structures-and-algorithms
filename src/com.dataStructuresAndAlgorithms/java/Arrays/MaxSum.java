package Arrays;

public class MaxSum {


    public int maxSum(int[][] grid) {
        int column = grid.length;
        int row = grid[0].length;
        int max = 0;
        for(int i = 1 ; i < column - 1 ; i ++){
            for(int j = 1 ; j < row - 1 ; j++ ){
                int x = grid[i][j] + grid[i-1][j] + grid[i-1][j-1]  + grid[i-1][j+1] + grid[i+1][j] + grid[i+1][j-1] + grid[i+1][j+1];
                max = Math.max(x,max);
            }
        }
        return max;
    }
}
