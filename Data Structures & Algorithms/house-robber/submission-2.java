class Solution {
    public int rob(int[] nums) {
        int robPrev = 0;      // max money if we robbed previous house
        int skipPrev = 0;     // max money if we skipped previous house

        for (int money : nums) {
            int robCurrent = skipPrev + money;          // must skip previous
            int skipCurrent = Math.max(skipPrev, robPrev); // choose best so far

            skipPrev = skipCurrent;
            robPrev = robCurrent;
        }

        return Math.max(robPrev, skipPrev);
    }
}