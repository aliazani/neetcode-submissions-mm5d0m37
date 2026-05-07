/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<Integer> starts = intervals.stream().map(i -> i.start)
                                .sorted((a,b) -> a-b)
                                .toList();
        List<Integer> ends = intervals.stream().map(i -> i.end)
                                .sorted((a, b) -> a-b)
                                .toList();
        
        int start = 0;
        int end = 0;

        int count = 0;
        int res = 0;

        while (start < intervals.size()) {
            if (starts.get(start) < ends.get(end)) {
                count++;
                start++;
            }
            else {
                count--;
                end++;
            }

            res = Math.max(res, count);
        }

        return res;
    }
}
