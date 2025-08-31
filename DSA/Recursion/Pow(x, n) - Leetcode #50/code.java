class Solution {
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