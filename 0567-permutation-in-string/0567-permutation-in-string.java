class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i = 0; i < s1.length(); i++)
        {
            char ch = s1.charAt(i);
            freq1[ch - 'a']++;
        }

        int l = 0, r = 0;

        while(r < s2.length())
        {
            char ch2 = s2.charAt(r);
            freq2[ch2 - 'a']++;

            while((r-l+1) > s1.length())
            {
                char ch3 = s2.charAt(l);
                freq2[ch3 - 'a']--;
                l++;
            }

            if(Arrays.equals(freq1,freq2)) return true;
            r++;
        }
        return false;
    }
}