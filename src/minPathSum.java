/**
 * @ClassName:minPathSum
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-path-sum/
 * @Date: 30/10/2022 11:08
 * @Version: v1.0
 */
public class minPathSum {

    public static void main(String[] args) {
        minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}});
    }
    static  public int minPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int row = grid.length;
        int col=grid[0].length;
        int[][] dp = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j] = grid[i][j];
                if(i>0 && j>0){
                    dp[i][j] += Math.min(dp[i-1][j],dp[i][j-1]);
                }else if(i>0){
                    dp[i][j] +=dp[i-1][j];
                }else if(j>0){
                    dp[i][j] +=dp[i][j-1];
                }
            }
        }
        return dp[row-1][col-1];
    }
}
