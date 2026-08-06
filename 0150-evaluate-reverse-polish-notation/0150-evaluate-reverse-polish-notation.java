class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < tokens.length; i++)
        {
            String token = tokens[i];

            if(token.equals("+") ||
            token.equals("-") ||
            token.equals("*") ||
            token.equals("/"))
            {
                int res1 = st.pop();
                int res2 = st.pop();

                int res = 0;
                if(token.equals("+"))
                res = (res1 + res2);
                else if(token.equals("*"))
                res = (res1 * res2);
                else if(token.equals("-"))
                res = (res2 - res1);
                else{
                if(res1 != 0)
                    res = (res2 / res1);
                }

                st.push(res);
            }
            else st.push(Integer.parseInt(tokens[i]));
        }

        return st.pop();
    }
}