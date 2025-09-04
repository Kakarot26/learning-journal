class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
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