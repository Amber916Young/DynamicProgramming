import java.util.Arrays;

/**
 * @ClassName:minFallingPathSum_hard
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/minimum-falling-path-sum-ii/
 * @Date: 30/10/2022 12:32
 * @Version: v1.0
 */
public class minFallingPathSum_hard {

    int[][] dp;
    public int minFallingPathSum(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        dp=new int[rows][cols];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cols; i++) {
            min=Math.min(min, DFS_minFallingPathSum_hard(grid,0,i ));
        }
        return min;
    }
    public int DFS_minFallingPathSum_hard(int[][] matrix,int row,int col){
        int rows = matrix.length, cols = matrix[0].length;
        if (row < 0 || row >= rows || col < 0 || col >= cols ) return Integer.MAX_VALUE;
        if(row == rows-1) return matrix[row][col];
        if(dp[row][col] != -1) return dp[row][col];
        int sum = Integer.MAX_VALUE;
        for(int i=0;i<cols;i++){
            if(i != col){
                sum = Math.min(sum,DFS_minFallingPathSum_hard(matrix,row + 1,i));
            }
        }
        dp[row][col] = matrix[row][col]+sum;
        return dp[row][col];
    }
}
