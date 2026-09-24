class Solution {
    public int f(int dp[][], int i, int amount, int coins[]){
        if(amount == 0) return 0;

        if(i == 0) {
            if(amount % coins[0] == 0)
                return amount / coins[0];

            return Integer.MAX_VALUE / 2;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int notTake = f(dp, i - 1, amount, coins);

        int take = Integer.MAX_VALUE / 2;

        if(coins[i] <= amount){
            take = 1 + f(dp, i, amount - coins[i], coins);
        }
        
        return dp[i][amount] = Math.min(take, notTake);

        }
        public int coinChange(int[] coins, int amount) {
            if(amount == 0) return 0;

            int dp[][] = new int[coins.length][amount+1];

            for(int i = 0; i < coins.length; i++) {
                Arrays.fill(dp[i], -1);
            }
            
            int ans = f(dp, coins.length - 1, amount, coins);

            if(ans == Integer.MAX_VALUE / 2) return -1;

            return ans; 
    }
}