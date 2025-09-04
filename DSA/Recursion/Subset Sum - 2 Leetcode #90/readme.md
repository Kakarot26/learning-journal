# **Problem Statement:**
>Given an integer array nums that may contain duplicates, return all possible subsets (the power set).

> The solution set must not contain duplicate subsets. Return the solution in any order.

## Constraints:
- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10

## My approach
Recursion Backtracking approach, take/not-take algorithm used.

```class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtrack(nums, 0, list, ans);
        return ans;
    }
    public void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i = index;i<nums.length;i++){
            if(i > index && nums[i] == nums[i - 1])    continue;
            list.add(nums[i]);
            backtrack(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
```
This was the optimal code

### Time & Space Complexity:
- Time: O(2^n)
- Space: O(2^n) in worst case, since we will be generating and storing all subsets.

### Reflection
It was easy, used the duplicate skipping technique i learned from Combination-Sum-2 problem.



