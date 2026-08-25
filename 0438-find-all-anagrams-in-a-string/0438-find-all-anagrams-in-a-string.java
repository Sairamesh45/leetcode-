class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int freq[] = new int[26];

        for(int i = 0; i < p.length(); i++)
        {
            char ch = p.charAt(i);
            freq[ch - 'a']++;
        }

        int l = 0, r = 0;
        List<Integer> list = new ArrayList<>();

        int freq1[] = new int[26];
        while(r < s.length())
        {
            char ch = s.charAt(r);
            freq1[ch - 'a']++;

            while((r - l + 1) > p.length())
            {
                char ch1 = s.charAt(l);
                freq1[ch1 - 'a']--;
                l++;
            }

            if(Arrays.equals(freq,freq1))
            list.add(l);

            r++;
        }

        return list;
    }
}