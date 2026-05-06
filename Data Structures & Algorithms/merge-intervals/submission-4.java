class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd   = intervals[i][1];
            int lastMergedEnd = merged.get(merged.size() - 1)[1];

            if (currStart <= lastMergedEnd) {
                merged.get(merged.size() - 1)[1] = Math.max(lastMergedEnd, currEnd);
            } else {
                merged.add(intervals[i]);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}