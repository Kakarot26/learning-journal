# **Problem Statement:**
>Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.

>Each number in candidates may only be used once in the combination.

>Note: The solution set must not contain duplicate combinations.

## Constraints:
- 1 <= candidates.length <= 100
- 1 <= candidates[i] <= 50
- 1 <= target <= 30

## My initial approach
I went with a simple Take/No-take approach in backtracking. Something unique and different in this question was that we were asked to not have any duplicates. For that, i used a Set, and sorted the given Array, and checked whether the list is already inside the Set.
This Solution was too inefficient and was getting Time Limit Error.

```
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        recursion(candidates, 0, target, list, ans, set);
        return ans;
    }
    public void recursion(int[] arr, int index, int target, List<Integer> list, List<List<Integer>> ans, Set<List<Integer>> set){
        if(index == arr.length){
            if(target == 0){
                if(set.contains(list))  return;
                ans.add(new ArrayList<>(list));
                set.add(new ArrayList<>(list));
            }
            return;
        }
        if(arr[index] <= target){
            list.add(arr[index]);
            recursion(arr, index + 1, target - arr[index], list, ans, set);
            list.remove(list.size() - 1);
        }
        recursion(arr, index + 1, target, list, ans, set);
    }
}
```

## What i improved
I learned a new way of using take/no-take approach in backtracking, rather than calling the function twice, i ran a loop from the current index, and inside that loop, after some pruning conditions, i called the function.
This was much better solution and worked.

Final Solution:
```
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursion(candidates, 0, target, list, ans);
        return ans;
    }
    public void recursion(int[] arr, int index, int target, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = index;i<arr.length;i++){
            if(i > index && arr[i] == arr[i - 1])   continue;
            if(arr[i] > target) break;
            list.add(arr[i]);
            recursion(arr, i + 1, target - arr[i], list, ans);
            list.remove(list.size() - 1);
        }
    }
}
```
### Time & Space Complexity:
- Time: O(2^n)
- Space: O(n)

### Reflection
I learned a new way of optimizing recursion.



