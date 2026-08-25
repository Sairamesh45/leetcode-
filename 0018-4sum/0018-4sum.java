class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // -2 -1 0 0 1 2
        List<List<Integer>> arr = new ArrayList<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++)
        {
            int a = nums[i];

            for(int j = i + 1; j < nums.length; j++)
            {
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int b = nums[j];
                long tar = (long) target - a - b;
                int l = j + 1, r = nums.length - 1;

                while(l < r)
                {
                    long sum = (long) nums[l] + nums[r];
                    List<Integer> list = new ArrayList<>();
                    if(sum == tar)
                    {
                        list.add(a);
                        list.add(b);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        if(!arr.contains(list))
                            arr.add(list);
                        l++;
                        r--;
                    }
                    else if(sum > tar) r--;
                    else l++;
                }
            }
        }
        return arr;
    }
}