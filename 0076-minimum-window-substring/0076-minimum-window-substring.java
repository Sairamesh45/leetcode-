class Solution {
    public String minWindow(String s, String t) {
        int freq[] = new int[128];

        for(int i = 0; i < t.length(); i++)
        {
            char ch = t.charAt(i);
            freq[ch]++;
        }

        int l = 0, r = 0;
        int min = Integer.MAX_VALUE;
        int start = -1, end = -1;

        int req = t.length();

        while(r < s.length())
        {
            char ch1 = s.charAt(r);

            if(freq[ch1] > 0){
                req--;
            }

            freq[ch1]--;

            while(req == 0)
            {
                if(r - l + 1 < min)
                {
                    start = l;
                    end = r;
                    min = r - l + 1;
                }

                char ch2 = s.charAt(l);
                freq[ch2]++;
                if(freq[ch2] > 0)
                req++;

                l++;
            }

            r++;
        }

        if(min == Integer.MAX_VALUE) return "";

        return s.substring(start, end + 1);
    }
}