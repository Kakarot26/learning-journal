# **Problem Statement:**
>Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
>Only numbers 1 through 9 are used.
>Each number is used at most once.
>Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
## Constraints:
- 2 <= k <= 9
- 1 <= n <= 60

## My initial approach
I tried to break the problem into smaller problems and approach it in a similar fashion as previous combination sum problems.

```class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if(k > 9 || k < 1 || k > n)  return ans;
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[9];
        backtrack(arr, k, n, list, ans, map);
        return ans;
    }
    public void backtrack(int[] arr, int k, int n, List<Integer> list, List<List<Integer>> ans, Map<Integer, Integer> map){
        if(k == 0){
            if(n == 0){
                boolean valid = false;
                for(int i = 0;i<list.size();i++){
                    if(!map.containsKey(list.get(i))){
                        System.out.print("Got " + i + " ");
                        valid = true;
                        map.put(list.get(i), 1);
                    }
                }
                if(valid)   ans.add(new ArrayList<>(list));
            }
            return;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == 1) continue;
            arr[i] = 1;
            list.add(i + 1);
            backtrack(arr, k - 1, n - (i + 1), list, ans, map);
            arr[i] = 0;
            list.remove(list.size() - 1);
        }
    }
}
```
This did not work, i was able to avoid duplicates but because of that, many combinations were being avoided as well. 

## What i learned:
A simpler mindset would've had me solving this problem easily.
I was thinking too much, was got overwhelmed by it, as if i weaved myself a trap, then kept going more and more entrapped. In the end, the solution did not require any arrays, maps, etc. Only Start index variable.

Final Solution:
```class Solution {
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
```
### Time & Space Complexity:
- Time: O(C(9, k)) where C represents Combination
- Space: O(k) due to recursion stack

### Reflection
I couldn't crack this one initially, and had mixed feelings when i got to how simple the solution was. Learned a new thing, keep your head cool. Don't chase your own tail. I made a model of the solution in my head, thought it would work, then kept adding fixes and conditions on top of it. Sometimes we should ponder whether out first model is flawed or not and not get stuck on it even when it starts to waver.



