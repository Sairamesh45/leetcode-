class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < num.length(); i++)
        {
            char currentDigit = num.charAt(i);
            while(!st.isEmpty() && k > 0 && st.peek() > currentDigit)
            {
                st.pop();
                k--;
            }
            st.push(currentDigit);
        }
        while(k > 0)
        {
            st.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        if(st.size() == 0) str.append('0');
        for(char ch : st)
        {
            str.append(ch);
        }

        int firstNonZeroIndex = -1;
        for(int i = 0; i < str.length(); i++)
        {
            char ch = str.charAt(i);

            if(ch != '0'){
                firstNonZeroIndex = i;
                break;
            } 
        }
        if(firstNonZeroIndex == -1)
            return "0";

        return str.substring(firstNonZeroIndex, str.length());
    }
}