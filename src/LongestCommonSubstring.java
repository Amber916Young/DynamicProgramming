/**
 * @ClassName:LongestCommonSubstring
 * @Auther: yyj
 * @Description:
 * @Date: 18/10/2022 23:27
 * @Version: v1.0
 */
public class LongestCommonSubsequence {

    //1143. Longest Common Subsequence
    public static void main(String[] args) {
        longestCommonSubsequence("abcde","ace");
    }

   static public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 0;i <= n;i++){
            for(int j = 0;j <= m;j++){
                if(i==0 || j== 0) {
                    dp[i][j] = 0;
                    continue;
                }
                char t1 = text1.charAt(i-1);
                char t2 = text2.charAt(j-1);
                if(t1 == t2) dp[i][j] = dp[i-1][j-1] + 1;
                else  dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }

        return dp[n][m];


    }
}
