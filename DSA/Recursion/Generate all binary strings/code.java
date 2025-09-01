import java.util.*;
class Solution {
    public static List<String> generateBinaryStrings(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        recursion(sb, n, ans);
        return ans;
    }
    public static void recursion(StringBuilder sb, int n, List<String> ans){
        if(n == 0){
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '1')    return;
        sb.append('1');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
}