import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(k > 9 || k < 1 || k > n)  return ans;
        List<Integer> list = new ArrayList<>();
        backtrack(1, k, n, list, ans);
        return ans;
    }
    public void backtrack(int start, int k, int n, List<Integer> list, List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k == 0 || n < 0) return;
        for(int i = start;i<=9;i++){
            list.add(i);
            backtrack(i + 1, k - 1, n - i, list, ans);
            list.remove(list.size() - 1);
        }
    }
}