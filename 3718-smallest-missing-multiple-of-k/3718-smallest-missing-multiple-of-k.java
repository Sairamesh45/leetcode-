class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for(int i : nums)
        {
            set.add(i);
        }
        int a = k;
        while(true)
        {
            if(!set.contains(a)) return a;
            else a += k;
        }
    }
}