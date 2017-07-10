from collections import deque
class Solution(object):
    def findOrder(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: List[int]
        """
        edges = [[] for _ in range(numCourses)] # store edges[start]
        cnt = [0 for _ in range(numCourses)]

        for end, start in prerequisites:
            edges[start].append(end)
            cnt[end] += 1

        ret = []
        pq = deque([i for i in range(numCourses) if cnt[i]==0])

        while pq:
            node = pq.popleft()
            ret.append(node)
            for n in edges[node]:
                cnt[n] -= 1
                if cnt[n] == 0:
                    pq.append(n)
        if len(ret) == numCourses:
            return ret
        else:
            return []