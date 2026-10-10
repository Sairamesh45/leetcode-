class Solution {
    public double myPow(double x, int n) {
        long N = n;

        double result = fastPow(x, N);

        return N > 0 ? result : 1 / result;
    }

    public double fastPow(double x, long n){
        if(n == 0) return 1;

        double half = fastPow(x, n / 2);

        if(n % 2 == 0) return half * half;
        return x * half * half;
    }
}