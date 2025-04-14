package Arrays;

public class NumberOfSubmatrices {


    public int numberOfSubmatrices(char[][] grid) {

        /*
         *      输入： grid = [["X","Y","."],["Y",".","."]]
         *      输出：3
         *      x   y  .
         *      y   .   .
         *
         *
         */
        int xNum = 0 ;
        int yNum = 0;
        int result =0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 'X') {
                    xNum ++;
                } else if (grid[i][j] == 'Y') {
                    yNum++;
                }
                if(xNum!= 0 && yNum != 0 && xNum == yNum) result ++;
            }
        }
        return result;
    }
}
