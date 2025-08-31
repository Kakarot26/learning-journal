# **Problem Statement:**
>Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

## Constraints:
- -100.0 < x < 100.0
- -231 <= n <= 231-1
- n is an integer.
- Either x is not zero or n > 0.
- -104 <= xn <= 104

## My initial approach
I tried basic recursive method using wrapper class

```class Solution {
    static class Wrapper{
        double digit = 0;
        int exponent = 0;
        Wrapper(double x, int n){
            this.digit = x;
            this.exponent = n;
        }
    }
    public double myPow(double x, int n) {
        if(n == 0)  return 1;
        Wrapper wrap = new Wrapper(x, n);
        if(n > 0)   exponent(wrap, x);
        else{
            wrap.digit = 1/wrap.digit;
            wrap.exponent = -wrap.exponent;
            exponent(wrap, 1/x);
        } 
        return wrap.digit;
    }
    public void exponent(Wrapper wrapper, double num){
        if(wrapper.exponent == 0 || wrapper.exponent == 1)   return;
            System.out.println("Current: " + wrapper.digit); 
            wrapper.digit = wrapper.digit * num;
            System.out.println("After: " + wrapper.digit); 
            wrapper.exponent -= 1;
            System.out.println("Exponent Remaining: " + wrapper.exponent);
            exponent(wrapper, num);
    }
}
```
This worked for small values but failed for larger test cases. 

## What i learned: Exponentiation by squaring
This algorithm reduces the number of multiplications by splitting the power in half.

>if n is even: 
_x ^ n = (x ^ (n/2) ^ 2)_

>if n is odd: _x ^ n = (x ^ (n/2) ^ 2) * x_

Example: 
To compute 2^5, we do:
- 2^2 * 2^2 * 2 = 32

For even n, such as 2^3, it's as simple as doing
- 2^6 = 2^3 * 2^3 = 64

Final Solution:
```class Solution {
    public double myPow(double x, int n) {
        if(n == 0)  return 1;
        if(n < 0){
            x = 1/x;
            if(n == Integer.MIN_VALUE){
                return x * myPow(x, Integer.MAX_VALUE);
            }
            n = -n;
        }
        return helper(x, n);
    }
    double helper(double x, int n){
        if(n == 0)  return 1;
        double half = helper(x, n/2);
        if(n % 2 == 0)  return half * half;
        else    return half * half * x;
    }
}
```
### Time & Space Complexity:
- Time: O(log n)
- Space: O(log n) due to recursion stack

### Reflection
I couldn't crack this one initially, but learning about this new algorithm was interesting, it's a great example of how mathematical insights can vastly improve performance.



