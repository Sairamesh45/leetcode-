class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 2; i++)
        {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

        
            int curr = nums[i];

            int l = i + 1, r = nums.length - 1;
            int sum = 0;

            while(l < r){
                sum = nums[l] + nums[r];

                if(sum + curr == 0){
                    List<Integer> arr = new ArrayList<>();

                    arr.add(nums[l]);
                    arr.add(nums[r]);
                    arr.add(curr);
                    
                    list.add(arr);
                    l++;
                    r--;

                    while (l < r && nums[l] == nums[l - 1])
                        l++;

                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }    
                else if(sum + curr > 0) r--;
                else l++;
            }
        }
        return list;
    }
}