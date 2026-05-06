class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:
        intervals.sort(key=lambda interval: interval[0])
        merged = [intervals[0]]

        for curr_start, curr_end in intervals[1:]:
            last_merged_end = merged[-1][1]

            if curr_start <= last_merged_end:
                merged[-1][1] = max(last_merged_end, curr_end)
            else:
                merged.append([curr_start, curr_end])

        return merged