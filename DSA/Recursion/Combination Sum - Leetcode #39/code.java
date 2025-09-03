import java.util.*;
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(candidates, 0, target, list, ans);
        return ans;
    }
    public void recursion(int[] candidates, int index, int target, List<Integer> list, List<List<Integer>> ans){
        if(index == candidates.length){
            if(0 == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(candidates[index] <= target){
            list.add(candidates[index]);
            recursion(candidates, index, target - candidates[index], list, ans);
            list.remove(list.size() - 1);
        }
        recursion(candidates, index + 1, target, list, ans);
    }
}