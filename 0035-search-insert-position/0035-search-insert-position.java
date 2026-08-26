class Solution {
    public int searchInsert(int[] nums, int target) {
        if(target > nums[nums.length-1]) return nums.length;
        int low = 0, high = nums.length - 1;
        int index = 0;

        while(low < high)
        {
            int mid = (low + high) / 2;

            if(nums[mid] < target)
            {
                low = mid + 1;
            }

            else high = mid;
        }
        return high;
    }
}