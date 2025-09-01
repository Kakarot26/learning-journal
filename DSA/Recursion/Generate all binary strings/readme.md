# **Problem Statement:**
>Given an integer N , Print all binary strings of size N which do not contain consecutive 1s.

>A binary string is that string which contains only 0 and 1.

## Constraints:
- 1 <= N <= 20

## My initial approach
Parameterized Recursion, using StringBuilder to store each string, going with, take/no-take algorithm, recursion and validation of string has been separated.

```
class Solution {
    public static List<String> generateBinaryStrings(int n) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        recursion(sb, n, ans);
        return ans;
    }
    public static void recursion(StringBuilder sb, int n, List<String> ans){
        if(n == 0){
            if(check(sb) == true)
                ans.add(sb.toString());
            return;
        }
        sb.append('0');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
        sb.append('1');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
    public static boolean check(StringBuilder sb){
        for(int i = 1;i<sb.length();i++){
            if(sb.charAt(i) == '1' && sb.charAt(i - 1) == '1')  return false;
        }
        return true;
    }
}
```
This worked for small values but failed for larger test cases. 

## What i improved
This algorithm was ineffective since i was using extra O(n) time for each check.
Therefore, instead of using a different function for validation, i pruned the recursion and cut off the pathway of two 1s being consecutively together.

This reduced the extra O(n) time.

Final Solution:
```
class Solution {
    public static List<String> generateBinaryStrings(int n) {
        // code here
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        recursion(sb, n, ans);
        return ans;
    }
    public static void recursion(StringBuilder sb, int n, List<String> ans){
        if(n == 0){
            ans.add(sb.toString());
            return;
        }
        sb.append('0');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
        if(sb.length() > 0 && sb.charAt(sb.length() - 1) == '1')    return;
        sb.append('1');
        recursion(sb, n - 1, ans);
        sb.deleteCharAt(sb.length() - 1);
    }
}
```
### Time & Space Complexity:
- Time: O(2^n)
- Space: O(n) by recursion stack (Space taken by list to store answer is not included)

### Reflection
I learned a new way of optimizing recursion.



