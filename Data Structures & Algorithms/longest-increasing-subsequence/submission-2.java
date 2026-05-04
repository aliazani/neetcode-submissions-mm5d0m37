class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lisFrom = new int[n];
        Arrays.fill(lisFrom, 1);

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j])
                    lisFrom[i] = Math.max(lisFrom[i], 1 + lisFrom[j]);
            }
        }

        int best = 0;
        for (int x : lisFrom) best = Math.max(best, x);
        return best;
    }
}