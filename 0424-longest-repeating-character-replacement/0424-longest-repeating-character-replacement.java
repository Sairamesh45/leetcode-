class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();

        int l = 0, r = 0;

        int max = 0;
        int maxFreq = 0;

        while(r < s.length())
        {
            char ch = s.charAt(r);
            map.put(ch, map.getOrDefault(ch,0)+1);
            maxFreq = Math.max(maxFreq, map.get(ch));

            while(r - l + 1 > (maxFreq + k))
            {
                char ch1 = s.charAt(l);

                map.put(ch1, map.get(ch1) - 1);

                if(map.get(ch1) == 0) map.remove(ch1);

                l++;
            }

            max = Math.max(max, r - l + 1);
            r++;
        }

        return max;
    }
}