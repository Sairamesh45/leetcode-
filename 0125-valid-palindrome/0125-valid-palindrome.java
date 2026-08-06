class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String t = "";

        for(int i = 0; i < s.length(); i++)
        {
            char ch = s.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                t += ch;
            }
        }

        int l = 0, r = t.length() - 1;
        while(l < r)
        {
            if(t.charAt(l) != t.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}