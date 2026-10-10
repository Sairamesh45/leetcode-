class Solution {
    public void fn(int i, int dp[], int n){
        if(i > n) return;

        dp[i] = dp[i - 1] + dp[i - 2];
        fn(i + 1, dp, n);
    }
    public int climbStairs(int n) {
        if(n <= 2) return n;

        int dp[] = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;
        
        fn(3, dp, n);

        return dp[n];
    }
}