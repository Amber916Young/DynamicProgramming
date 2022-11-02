import java.util.Arrays;

/**
 * @ClassName:lengthOfLIS
 * @Auther: yyj
 * @Description: https://leetcode.com/problems/longest-increasing-subsequence/
 * @Date: 02/11/2022 18:58
 * @Version: v1.0
 */
public class lengthOfLIS {

    /**
     * Given an integer array nums, return the length of the longest strictly increasing subsequence.
     *
     * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
     *
     *
     *
     * Example 1:
     *
     * Input: nums = [10,9,2,5,3,7,101,18]
     * Output: 4
     * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
     * Example 2:
     *
     * Input: nums = [0,1,0,3,2,3]
     * Output: 4
     * Example 3:
     *
     * Input: nums = [7,7,7,7,7,7,7]
     * Output: 1
     */
    public static void main(String[] args) {
        lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6});
    }
    static public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for(int i =0;i<dp.length;i++){
            ans = Math.max(ans,dp[i]);
        }
        return ans;

    }
}
