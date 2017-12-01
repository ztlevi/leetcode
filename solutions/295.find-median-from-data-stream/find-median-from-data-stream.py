import heapq
class MedianFinder(object):
    def __init__(self):
        """
        initialize your data structure here.
        """
        self.left = []
        self.right = []

    def addNum(self, num):
        """
        :type num: int
        :rtype: void
        """
        heapq.heappush(self.right, -heapq.heappushpop(self.left, -num))
        if len(self.left) < len(self.right):
            heapq.heappush(self.left, -heapq.heappop(self.right))

    def findMedian(self):
        """
        :rtype: float
        """
        if not self.left and not self.right:
            return 0
        if (len(self.right) + len(self.left)) % 2 == 1:
            return float(-self.left[0])
        else:
            return (-self.left[0] + self.right[0]) / 2.0


        # Your MedianFinder object will be instantiated and called as such:
        # obj = MedianFinder()
        # obj.addNum(num)
        # param_2 = obj.findMedian()