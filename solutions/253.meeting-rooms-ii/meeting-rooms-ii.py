# Definition for an interval.
# class Interval(object):
#     def __init__(self, s=0, e=0):
#         self.start = s
#         self.end = e

class Solution(object):
    def minMeetingRooms(self, intervals):
        """
        :type intervals: List[Interval]
        :rtype: int
        """
        from heapq import *
        intervals.sort(key=lambda i:i.start)
        rooms = 0
        pq = [] # this is the priority queue, store the rooms' endtimes
        
        for i in intervals:
            if pq and pq[0] <= i.start:
                heappop(pq) # pop the room with the earliest endtime
            heappush(pq, i.end)
        # the length of pq is the rooms needed
        return len(pq)
