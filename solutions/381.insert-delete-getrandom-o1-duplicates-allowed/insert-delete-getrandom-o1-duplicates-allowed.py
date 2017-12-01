class RandomizedCollection(object):

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.vals = []; self.pos = collections.defaultdict(set)

    def insert(self, val):
        """
        Inserts a value to thecollection. Returns true if the collection did not already contain the specified element.
        :type val: int 
        :rtype: bool
        """
        self.vals.append(val)
        self.pos[val].add(len(self.vals) - 1)
        return len(self.pos[val]) == 1

    def remove(self, val):
        """
        Removes a value from the collection. Returns true if the collection contained the specified element.
        :type val: int
        :rtype: bool
        """
        if self.pos[val]:
            lastVal = self.vals[-1]
            idx = self.pos[val].pop()
            self.vals[idx] = lastVal
            if self.pos[lastVal]:
                self.pos[lastVal].add(idx)
                self.pos[lastVal].discard(len(self.vals) - 1)
            self.vals.pop()
            return True
        else: return False        

    def getRandom(self):
        """
        Get a random element from the collection.
        :rtype: int
        """
        return random.choice(self.vals)


# Your RandomizedCollection object will be instantiated and called as such:
# obj = RandomizedCollection()
# param_1 = obj.insert(val)
# param_2 = obj.remove(val)
# param_3 = obj.getRandom()