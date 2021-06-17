package pooshapman.dp;

public class dp01 {
    public static void main(String[] args) {
        int[] nums = { 2, 7, 9, 3, 1, 8};
        System.out.println(solve(nums));
    }

    private static int solve(int[] nums) {
        int result = 0;
        int len = nums.length;

        int[] dp = new int[len];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i=2; i<len; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }

        result = dp[len - 1];

        return result;
    }


}
