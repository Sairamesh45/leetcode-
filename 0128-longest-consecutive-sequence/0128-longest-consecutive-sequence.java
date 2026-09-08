class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums)
        {
            set.add(i);
        }

        int max = 0;
        for(int i : set)
        {
            if(!set.contains(i - 1))
            {
                int count = 1;
                while(set.contains(i + count))
                {
                    count++;
                }
                max = Math.max(count,max);
            }
        }

        return max;
    }
}