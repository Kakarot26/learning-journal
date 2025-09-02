# **Problem Statement:**
>Given an integer array nums of unique elements, return all possible subsets (the power set).

>The solution set must not contain duplicate subsets. Return the solution in any order.

## Constraints:
- 1 <= nums.length <= 10
- -10 <= nums[i] <= 10
- All the numbers of nums are unique.

## My approach
Recursion Backtracking approach, take/not-take algorithm used.

```class Solution {
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
        //take
        list.add(nums[index]);
        recursion(nums, index + 1, list, ans);
        //remove
        list.remove(list.size() - 1);
        //no-take
        recursion(nums, index + 1, list, ans);
    }
}
```
This was the optimal code

### Time & Space Complexity:
- Time: O(2^n)
- Space: O(n) due to recursion stack (excluding output space)

### Reflection
It was easy, and backtracking is such a cool thing, feels like a sugar rush when your code works.



