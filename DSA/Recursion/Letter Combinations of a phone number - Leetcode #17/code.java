import java.util.*;
class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0)  return ans;
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), ans, arr);
        return ans;
    }
    public void backtrack(String digits, int index, StringBuilder sb, List<String> ans, String[] arr){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = arr[digits.charAt(index) - '0'];
        for(char ch:letters.toCharArray()){
            sb.append(ch);
            backtrack(digits, index + 1, sb, ans, arr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}