class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int n : nums)
        {
            set.add(n);
        }
        int max = 0;
        for(int i : set)
        {
            if(!set.contains(i-1))
            {
                int count = 1;
                while(set.contains(i+count))
                    count++;
                max = Math.max(max,count);
            }
        }
        return max;
    }
}