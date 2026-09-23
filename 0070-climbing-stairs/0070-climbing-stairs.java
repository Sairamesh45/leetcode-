class Solution {
    public int climbStairs(int n) {
        int prev = 1;
        int prev2 = 1;

        if(n <= 1) return n;
        for(int i = 2; i <= n; i++){
            int currI = prev + prev2;
            prev2 = prev;
            prev = currI;
        }

        return prev;
    }
}