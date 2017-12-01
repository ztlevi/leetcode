class MyQueue(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.input = []
        self.output = []

    def push(self, x):
        """
        Push element x to the back of queue.
        :type x: int
        :rtype: void
        """
        self.input.append(x)

    def pop(self):
        """
        Removes the element from in front of queue and returns that element.
        :rtype: int
        """
        if self.output:
            return self.output.pop()
        self.move()
        return self.output.pop() if self.output else -1

    def peek(self):
        """
        Get the front element.
        :rtype: int
        """
        if self.output:
            return self.output[-1]
        self.move()
        return self.output[-1] if self.output else -1

    def empty(self):
        """
        Returns whether the queue is empty.
        :rtype: bool
        """
        if len(self.input) or len(self.output):
            return False
        else: return True
        
    def move(self):
        while self.input:
            self.output.append(self.input.pop()) 


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()