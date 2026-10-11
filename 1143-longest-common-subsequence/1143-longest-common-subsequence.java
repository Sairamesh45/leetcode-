class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int l = 1, r = 1;
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        dp[0][0] = 0;

        for(int i = 1; i <= text1.length(); i++){
            for(int j = 1; j <= text2.length(); j++){
                char ch1 = text1.charAt(i - 1);
                char ch2 = text2.charAt(j - 1);

                dp[i][j] = (ch1 == ch2) ? dp[i-1][j-1] + 1 : Math.max(dp[i][j-1], dp[i-1][j]);
            }
        }
        return dp[text1.length()][text2.length()];
    }
}