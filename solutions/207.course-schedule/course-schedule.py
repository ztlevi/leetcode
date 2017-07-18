from collections import deque
class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        map = {i: set() for i in range(numCourses)} # course number : prerequisites set
        
        for p in prerequisites:
            course, prerequisite = p[0], p[1]
            map[course].add(prerequisite)
        
        cnt = [len(map[i]) for i in range(numCourses)]
        
        pq = deque([i for i in range(numCourses) if cnt[i]==0]) # (num of set, course)
        count = 0
        while pq:
            course = pq.popleft()
            count += 1
            for i in range(numCourses):
                if course in map[i]:
                    map[i].remove(course)
                    cnt[i] -= 1
                    if cnt[i] == 0:
                        pq.append(i)
        return True if count == numCourses else False
            