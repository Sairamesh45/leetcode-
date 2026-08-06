class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++)
        {
            int x = nums[i];
            int left = i + 1;
            int target = 0 - x;
            int right = nums.length - 1;

            if(i > 0 && nums[i] == nums[i-1]) continue;

            while(left < right)
            {
                if(nums[left] + nums[right] == target)
                {
                    List<Integer> l = new ArrayList<>();
                    l.add(nums[left]);
                    l.add(nums[right]);
                    l.add(x);
                    list.add(l);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;

                }

                
                else if(nums[left] + nums[right] < target) left++;
                else right--;
            }
        }
        return list;
    }
}