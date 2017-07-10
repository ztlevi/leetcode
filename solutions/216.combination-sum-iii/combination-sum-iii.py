class Solution(object):
    def combinationSum3(self, k, n):
        """
        :type k: int
        :type n: int
        :rtype: List[List[int]]
        """
        if n > sum([i for i in range(1, 10)]):
            return []

        rst = []

        def helper(k, n, curr, arr):
            if n == 0 and k == 0:
                rst.append(list(arr))
                return
        
            for i in range(curr+1, 10):
                if n>= i:
                    arr.append(i)
                    helper(k-1, n-i, i, arr)
                    arr.pop()
                else:
                    break

        helper(k, n, 0, [])
        return rst
        
# so = Solution()
# so.combinationSum3(3,7)