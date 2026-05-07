"""
Definition of Interval:
class Interval(object):
    def __init__(self, start, end):
        self.start = start
        self.end = end
"""

class Solution:
    def minMeetingRooms(self, intervals: List[Interval]) -> int:
        starts: list[int] = sorted([i.start for i in intervals])
        ends: list[int] = sorted([i.end for i in intervals])

        start: int = 0
        end: int = 0
        
        count: int = 0
        res: int = 0


        while start < len(intervals):
            if starts[start] < ends[end]:
                count += 1
                start +=1
            else:
                count -= 1
                end += 1
            
            res = max(res, count)

        return res

