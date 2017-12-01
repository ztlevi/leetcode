class Solution:
    def leastInterval(self, tasks, n):
        """
        :type tasks: List[str]
        :type n: int
        :rtype: int
        """
        task_counter = list(collections.Counter(tasks).values());
        M = max(task_counter)
        cM = task_counter.count(M)
        return max(len(tasks), (M - 1) * (n + 1) + cM)
        