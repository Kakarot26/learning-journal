import java.util.*;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(nums, 0, list, ans);
        return ans;
    }
    public void recursion(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
        if(index == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[index]);
        recursion(nums, index + 1, list, ans);
        list.remove(list.size() - 1);
        recursion(nums, index + 1, list, ans);
    }
}