# **Problem Statement:**
>Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

## Constraints:
- 1 <= n <= 8

## My initial approach
I tried to do it by taking a completion counter, which stored how many parentheses are open and need to be closed, the code got very messy and didn't work, i debugged it and got it working for a few test cases, but eventually gave since the whole code became way too complex.

## How it was solved
It was solved by taking two variables to keep count of open parentheses and close parentheses, a simple and effective approach utilizing backtracking.

The base case is when string's length equals twice on n, because each n, there'll be a pair of parentheses.

Final Solution:
```
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        recursion(ans, new StringBuilder(), n, 0, 0);
        return ans;
    }
    public void recursion(List<String> ans, StringBuilder sb, int n, int open, int close){
        if(sb.length() == 2*n){
            ans.add(sb.toString());
            return;
        }
        if(open < n){
            sb.append('(');
            recursion(ans, sb, n, open + 1, close);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(close < open){
            sb.append(')');
            recursion(ans, sb, n, open, close + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```
### Time & Space Complexity:
- Time: O(2n)
- Space: O(n*n) by recursion stack (Space taken by list to store answer is not included)

### Reflection
I learned a new way of optimizing recursion.