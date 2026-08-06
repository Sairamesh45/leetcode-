class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length - 1]) return nums.length;
        int low = 0, high = nums.length - 1;

        while(low < high)
        {
            int mid = (low + high) / 2;

            if(nums[mid] >= target)
            {
                high = mid;
            }

            else low = mid + 1;
        }

        return high;
    }
}