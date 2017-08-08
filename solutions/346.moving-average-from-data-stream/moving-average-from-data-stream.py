class MovingAverage(object):

    def __init__(self, size):
        """
        Initialize your data structure here.
        :type size: int
        """
        self.length = size
        self.arr = []

    def next(self, val):
        """
        :type val: int
        :rtype: float
        """
        self.arr.append(val)
        if len(self.arr) > self.length:
            self.arr.pop(0)
        arrSum = sum(self.arr)
        return arrSum / float(len(self.arr))
        


# Your MovingAverage object will be instantiated and called as such:
# obj = MovingAverage(size)
# param_1 = obj.next(val)