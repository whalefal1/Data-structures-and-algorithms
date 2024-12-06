package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
       List<String> res  = new ArrayList<>();
       StringBuilder stringBuilder = new StringBuilder();
        backTracing(n,0,stringBuilder,res);
        return  res;
    }
    private void backTracing(int left ,int right,StringBuilder stringBuilder,List<String> res ){
        if(left + right == 0){
            res.add(stringBuilder.toString());
            return;
        }
        if(left > 0){
            stringBuilder.append("(");
            backTracing(left-1,right+1,stringBuilder,res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }

        if(right > 0){
            stringBuilder.append(")");
            backTracing(left,right-1,stringBuilder,res);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
        }
    }

}
