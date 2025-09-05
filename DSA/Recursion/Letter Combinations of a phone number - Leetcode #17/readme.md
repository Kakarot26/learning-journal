# **Problem Statement:**
>Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

>A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

## Constraints:
- 0 <= digits.length <= 4
- digits[i] is a digit in the range ['2', '9'].

## My initial approach
Misunderstood the way i should've done it, flattened the String into one String and generated all combinations from that.

This generated unnecessary combinations. 

## What i learned: 
Again, the solution was pretty simple, we make an array and map letters to digits.
Then we choose one letter from digit -> Use backtracking -> Generate all possible combinations.

Final Solution:
```class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits == null || digits.length() == 0)  return ans;
        String arr[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), ans, arr);
        return ans;
    }
    public void backtrack(String digits, int index, StringBuilder sb, List<String> ans, String[] arr){
        if(index == digits.length()){
            ans.add(sb.toString());
            return;
        }
        String letters = arr[digits.charAt(index) - '0'];
        for(char ch:letters.toCharArray()){
            sb.append(ch);
            backtrack(digits, index + 1, sb, ans, arr);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
```
### Time & Space Complexity:
- Time: O(4^n) for n digits given, there's 3 choices (4 in worst case)
- Space: O(n) due to recursion stack and StringBuilder which we build each combination

### Reflection
I couldn't crack this one initially, but it was an interesting problem, specially when you understand how it works, it feels really nice, simple yet elegant.



