# The read4 API is already defined for you.
# @param buf, a list of characters
# @return an integer
# def read4(buf):
from collections import deque
class Solution(object):
    def __init__(self):
        self.buffer = collections.deque([])
        
    def read(self, buf, n):
        """
        :type buf: Destination buffer (List[str])
        :type n: Maximum number of characters to read (int)
        :rtype: The number of characters read (int)
        """
        idx = 0
        m = n
        while m > 0:
            buf4 = [""]*4
            l = read4(buf4)
            if not l:
                break
            for b in buf4:
                if b:
                    self.buffer.append(b)

            m -= 4
            
        for i in xrange(min(len(self.buffer), n)):
            buf[i] = self.buffer[0]
            self.buffer.popleft()
            idx += 1
        return idx