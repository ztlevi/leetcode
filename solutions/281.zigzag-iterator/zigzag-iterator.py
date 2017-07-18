class ZigzagIterator(object):

    def __init__(self, v1, v2):
        """
        Initialize your data structure here.
        :type v1: List[int]
        :type v2: List[int]
        """
        self.v = [(len(v), iter(v)) for v in (v1, v2) if v]
        

    def next(self):
        """
        :rtype: int
        """
        l, iter = self.v.pop(0)
        if l > 1:
            self.v.append((l - 1, iter))
        return next(iter)

    def hasNext(self):
        """
        :rtype: bool
        """
        if self.v:
            return True 
        else:
            return False
        

# Your ZigzagIterator object will be instantiated and called as such:
# i, v = ZigzagIterator(v1, v2), []
# while i.hasNext(): v.append(i.next())