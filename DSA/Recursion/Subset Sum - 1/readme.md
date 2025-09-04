# **Problem Statement:**
>Given an array of positive integers arr[] and a value sum, determine if there is a subset of arr[] with sum equal to given sum. 

## Constraints:
- 1 <= arr.size() <= 200
- 1<= arr[i] <= 200
- 1<= sum <= 104

## My approach
Recursion Backtracking approach, take/not-take algorithm used.

```class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        return backtrack(arr, 0, sum, 0);
    }
    static Boolean backtrack(int[] arr, int index, int target, int sum){
        if(sum > target)    return false;
        if(index == arr.length){
            if(target == sum)   return true;
            return false;
        }
        if(backtrack(arr, index + 1, target, sum + arr[index]) == true)   return true;
        if(backtrack(arr, index + 1, target, sum) == true) return true;
        return false;
    }
}
```
This was the optimal code

### Time & Space Complexity:
- Time: O(2^n)
- Space: O(n) due to recursion stack

### Reflection
It was easy, used a pattern i learned recently.



