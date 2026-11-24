class Solution {
    public double myPow(double x, int n) {
        if(x ==0) return 0;
        if(n == 0) return 1;

        double ans = helper(x, Math.abs((long)n));
        return n >= 0 ? ans : 1/ans;
    }
    public double helper(double x, long n){
        if( n == 0) return 1;

        double half = helper(x, n/2);
        return (n %2 == 0) ? half * half : x * half* half;
    }
}
