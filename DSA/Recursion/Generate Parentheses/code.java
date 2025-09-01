import java.util.*;
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recursion(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }
    public void recursion(List<String> ans, StringBuilder sb, int n, int open, int close){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            recursion(ans, sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            recursion(ans, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}