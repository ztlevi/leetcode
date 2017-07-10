# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def canAttendMeetings(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: bool
        """
        if not intervals:
            return True
        intervals = sorted(intervals, key=lambda i: i.start)
        lastInterval = intervals[0]
        for i in range(1, len(intervals)):
            currentInterval = intervals[i]
            if lastInterval.end > currentInterval.start:
                return False
            lastInterval = currentInterval
        return True
