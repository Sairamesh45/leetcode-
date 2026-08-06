class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int l = 0, r = 0;

        int max = 0;
        while(r < s.length())
        {
            char ch = s.charAt(r);

            while(map.containsKey(ch))
            {
                char ch1 = s.charAt(l);
                map.put(ch1, map.get(ch1) -1);
                if(map.get(ch1) == 0) map.remove(ch1);
                l++;
            }
            map.put(ch,map.getOrDefault(ch,0)+1);
            max = Math.max(max,r-l+1);
            r++;
        }
        return max;
    }
}