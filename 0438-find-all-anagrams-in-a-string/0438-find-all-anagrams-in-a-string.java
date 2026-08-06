class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int freq[] = new int[26];
        for(int i = 0; i < p.length(); i++)
        {
            freq[p.charAt(i) - 'a']++;
        }

        List<Integer> list = new ArrayList<>();

        int freq2[] = new int[26];
        int l = 0, r = 0;
        while(r < s.length())
        {
            freq2[s.charAt(r) - 'a']++;

            if(r-l+1 > p.length())
            {
                freq2[s.charAt(l) - 'a']--;
                l++;
            }

            if(Arrays.equals(freq,freq2))
            {
                list.add(l);
            }

            r++;
        }
        return list;
    }
}