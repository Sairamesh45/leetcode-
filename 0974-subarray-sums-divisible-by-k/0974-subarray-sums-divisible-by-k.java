class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int prefixSum[] = new int[nums.length];
        HashMap<Integer,Integer> map = new HashMap<>();

        prefixSum[0] = 0;
        for(int i = 1; i < nums.length; i++)
        {
            prefixSum[i] = prefixSum[i - 1] + nums[i - 1];
        }

        int count = 0;
        map.put(0, 1);

        int sum = 0;

        for(int i : nums)
        {
            sum += i;

            int rem = sum % k;

            if(rem < 0){
                rem += k;
            }

            if(map.containsKey(rem))
            {
                count += map.get(rem);
            }

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return count;
    }
}