class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        StringBuilder t = new StringBuilder();

        for(int i = 0; i < s.length(); i++)
        {
            if(Character.isLetterOrDigit(s.charAt(i)))
                t.append(s.charAt(i));
        }
        
        String a = t.toString();
        int l = 0, r = a.length() - 1;

        while(l < r)
        {
            if(a.charAt(l) != a.charAt(r)) return false;
            l++;
            r--;
        }

        return true;
    }
}