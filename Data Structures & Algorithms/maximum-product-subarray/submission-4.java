class Solution {
    public int maxProduct(int[] nums) {
        int best = Integer.MIN_VALUE;
        for (int n : nums) best = Math.max(best, n);  // manual max since Arrays.asList won't work on int[]

        int runningMax = 1, runningMin = 1;

        for (int n : nums) {
            int a = n * runningMax;
            int b = n * runningMin;

            runningMax = Math.max(n, Math.max(a, b));
            runningMin = Math.min(n, Math.min(a, b));
            best = Math.max(best, runningMax);
        }

        return best;
    }
}