import heapq

class LFUCache(object):

    def __init__(self, capacity):
        """
        :type capacity: int
        """
        self.capacity = capacity
        self.n = 0
        self.time = 0

        self.map = {} # key :
        self.freq_time = {} # key : (freq, time)
        # store the cache that are used later
        self.update = {} # key : (freq, time)
        # use priority queue to store the least frequeuntly used cache ordered by freq and then time
        self.priority_queue = [] # (freq, time, key)

    def get(self, key):
        """
        :type key: int
        :rtype: int
        """
        if self.capacity <= 0:
            return -1

        self.time += 1
        if key in self.map:
            freq, _ = self.freq_time[key]
            self.freq_time[key] = (freq + 1, self.time)
            self.update[key] = self.freq_time[key]
            return self.map[key]
        else:
            return -1

    def put(self, key, value):
        """
        :type key: int
        :type value: int
        :rtype: void
        """
        if self.capacity <= 0:
            return

        self.time += 1
        if key in self.map:
            freq, _ = self.freq_time[key]
            self.freq_time[key] = (freq + 1, self.time)
            self.update[key] = self.freq_time[key]
            self.map[key] = value
        else:
            if self.n < self.capacity:
                self.n += 1
            else:
                # update the caches in the update map
                # find the next one that has not been updated, which is the least frequently used
                while self.priority_queue and self.priority_queue[0][2] in self.update:
                    _, _, k = heapq.heappop(self.priority_queue)
                    heapq.heappush(self.priority_queue, self.update[k] + (k,))
                    del self.update[k]

                _, _, k = heapq.heappop(self.priority_queue)
                self.map.pop(k)
                self.freq_time.pop(k)

            self.map[key] = value
            self.freq_time[key] = (0, self.time)
            heapq.heappush(self.priority_queue, (0, self.time, key))

# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(3)
# rst = []
# obj.put(2, 2)
# obj.put(1, 1)
# rst.append(obj.get(1))
# rst.append(obj.get(2))
# obj.put(3, 3)
# obj.put(4, 4)
# rst.append(obj.get(3))
# rst.append(obj.get(2))
