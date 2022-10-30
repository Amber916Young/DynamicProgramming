/**
 * @ClassName:HouseRobber2
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/house-robber-ii/
 * @Date: 30/10/2022 12:41
 * @Version: v1.0
 */
public class HouseRobber2 {
    public static void main(String[] args) {
        HouseRobber2 test = new HouseRobber2();
        test.rob(new int[]{1,2,3,1});
    }
    public int help (int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }
        return dp[n];

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        int[] n1 = new int[nums.length-1];
        int[] n2 = new int[nums.length-1];
        System.arraycopy(nums, 1, n1, 0, nums.length - 1);
        System.arraycopy(nums, 0, n2, 0, nums.length - 1);
        int ans = help(n1);
        int ans2 = help(n2);
        return Math.max(ans,ans2);
    }
}
