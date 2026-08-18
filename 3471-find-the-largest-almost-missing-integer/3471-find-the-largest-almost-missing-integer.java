class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i : nums)
        {
            map.put(i, map.getOrDefault(i,0)+1);
        }

        if(k == nums.length)
        {
            int max = Integer.MIN_VALUE;

            for(int i = 0; i < nums.length; i++)
            {
                max = Math.max(max,nums[i]);
            }
            return max;
        }

        if(k == 1)
        {
            int max = -1;

            for(int i = 0; i < nums.length; i++)
            {
                if(map.get(nums[i]) == 1 && nums[i] > max){
                    max = nums[i];
                }
            }
            return max;
        }

        if(map.get(nums[0]) == 1 && map.get(nums[nums.length - 1]) == 1)
            return Math.max(nums[0], nums[nums.length - 1]);

        if(map.get(nums[0]) == 1 && map.get(nums[nums.length - 1]) > 1)
            return nums[0];

        if(map.get(nums[0]) > 1 && map.get(nums[nums.length - 1]) == 1)
            return nums[nums.length - 1];

        return -1; 
    }
}