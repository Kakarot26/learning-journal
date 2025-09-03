# **Problem Statement:**
>Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

>The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

>The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

## Constraints:
- 1 <= candidates.length <= 30
- 2 <= candidates[i] <= 40
- All elements of candidates are distinct.
- 1 <= target <= 40

## My initial approach
I went with a simple Take/No-take approach in backtracking. Something new in this question was, we were allowed to pick duplicates, so i modified the algorithm a bit, to keep picking the same the element without moving to next index and return if the sum happens to exceed target.

```
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        recursion(candidates, 0, target, 0, list, ans);
        return ans;
    }
    public void recursion(int[] candidates, int index, int target, int sum, List<Integer> list, List<List<Integer>> ans){
        if(index == candidates.length){
            if(sum == target){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(sum > target)    return;
        list.add(candidates[index]);
        recursion(candidates, index, target, sum + candidates[index], list, ans);
        list.remove(list.size() - 1);
        recursion(candidates, index + 1, target, sum, list, ans);
    }
}
```
This worked, but the solution was taking quite a bit of time.

## What i improved
I learned a new way of using take/no-take approach in backtracking, rather than keeping a different variable sum, we can just reduce the target. This was used to apply pruning conditions to the recursion and the solution became way better.

Final Solution:
```
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
```
### Time & Space Complexity:
- Time: O(2^n * t) (t is the number of recursion calls)
- Space: O(n * t)

### Reflection
I learned a new way of optimizing recursion.



