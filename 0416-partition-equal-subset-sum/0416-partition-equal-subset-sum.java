class Solution {
    public boolean f(int nums[], int i, int target, Boolean dp[][]){
        if(target == 0) return true;
        if(i == 0) return nums[0] == target;

        if(dp[i][target] != null) return dp[i][target];

        boolean notTake = f(nums, i - 1, target, dp);

        boolean take = false;
        if(nums[i] <= target)
            take = f(nums, i - 1, target - nums[i], dp);

        return dp[i][target] = take || notTake;
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        if(sum % 2 != 0) return false;

        sum = sum / 2;

        Boolean dp[][] = new Boolean[nums.length][sum + 1];

        return f(nums, nums.length - 1, sum, dp);
    }
}