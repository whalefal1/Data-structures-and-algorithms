package Arrays;

import java.util.HashMap;

public class IsValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        HashMap map = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map = new HashMap();
                if(map.containsKey(board[i][j])){
                    return false;
                }else{
                    map.put(board[i][j],"");
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                map = new HashMap();
                if(map.containsKey(board[j][i])){
                    return false;
                }else{
                    map.put(board[j][i],"");
                }
            }
        }

        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                map = new HashMap();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        int x = board[i+k][j+l];
                        if(map.containsKey(x)){
                            return false;
                        }else {
                            map.put(x,"");
                        }
                    }
                }
            }
        }
        return true;
    }
}
