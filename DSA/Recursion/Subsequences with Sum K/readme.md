# **Patterns to using BackTracking:**

>_**Print-All Pattern:**_ 

This is the type of pattern we may follow when we are asked to print all subsequences/subsets in any given problem.

```class Solution {
    public int subsequenceSum(int[] nums, int target) {
        List<Integer> ds = new ArrayList<>();
        recursion(nums, 0, target, 0, ans, ds);
        return ans.count;
    }
    public void recursion(int nums[], int index, int target, int sum, List<Integer> ds){
        if(index == nums.length){
            if(sum == target){
                for(int val:ds){
                    System.out.print(val + " ");
                }
                System.out.println();
            }
            return;
        }
        if(sum > target)    return;
        sum += nums[index];
        ds.add(nums[index]);
        recursion(nums, index + 1, target, sum, ds);
        sum -= nums[index];
        ds.remove(ds.size() - 1);
        recursion(nums, index + 1, target, sum, ds);
    }
}
```

>_**Print-One Pattern:**_

This is the type of pattern we may follow, when asked to print only 1 subsequence/subset in any given problem.

```class Solution {
    public int subsequenceSum(int[] nums, int target) {
        List<Integer> ds = new ArrayList<>();
        int ans = recursion(nums, 0, target, 0, ds);
        return ans;
    }
    public boolean recursion(int nums[], int index, int target, int sum, ds){
        if(sum > target)    return false;
        if(index == nums.length){
            if(sum == target){
                for(int val:ds){
                    System.out.print(val + " ");
                }
                System.out.println();
                return true;
            }
            return false;
        }
        ds.add(nums[index]);
        if(recursion(nums, index + 1, target, sum + nums[index], ds) == true){
            return true;
        }
        ds.remove(ds.size() - 1);
        if(recursion(nums, index + 1, target, sum + nums[index], ds) == true){
            return true;
        }
        return false;
    }
}
```

>_**Counting Pattern:**_

This is the type of pattern we may follow, when asked to find count of subsequence/subset in any given problem.

```class Solution {
    public int perfectSum(int[] nums, int target) {
        int ans = recursion(nums, 0, target, 0);
        return ans;
    }
    public int recursion(int nums[], int index, int target, int sum){
        if(sum > target)    return 0;
        if(index == nums.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        int left = recursion(nums, index + 1, target, sum + nums[index]);
        int right = recursion(nums, index + 1, target, sum);
        return left + right;
    }
}
```