class Solution {
    public int rob(int[] nums) {
        return Math.max(nums[0], Math.max(
            rob1(Arrays.copyOfRange(nums, 1, nums.length)),
            rob1(Arrays.copyOfRange(nums, 0, nums.length - 1))));
    }

    private int rob1(int[] nums) {
        int prev = 0;     // dp[i-1]
        int prePrev = 0;  // dp[i-2]

        for (int num: nums) {
            int curr = Math.max(num + prePrev, prev); // dp[i]

            prePrev = prev;
            prev = curr; 
        }

        return prev;
    }
}
