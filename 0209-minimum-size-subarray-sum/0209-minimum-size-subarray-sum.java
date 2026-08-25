class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int minSize = Integer.MAX_VALUE;

        while(r < nums.length)
        {
            sum += nums[r];

            while(sum >= target){
                minSize = Math.min(minSize, r-l+1);
                sum -= nums[l];
                l++;
            }

            if(sum < target) r++;
        }
        if(minSize == Integer.MAX_VALUE) return 0;
        return minSize;
    }
}