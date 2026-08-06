class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];

        for(int i = 0; i < s1.length(); i++)
        {
            freq[s1.charAt(i) - 'a']++;
        }

        int l = 0, r =0;
        int freq2[] = new int[26];
        while(r < s2.length())
        {
            freq2[s2.charAt(r) - 'a']++;

            if((r-l+1) > s1.length()){
                freq2[s2.charAt(l) - 'a']--;
                l++;
            }
            if(Arrays.equals(freq,freq2)) return true;
            r++;
        }
        return false;
    }
}