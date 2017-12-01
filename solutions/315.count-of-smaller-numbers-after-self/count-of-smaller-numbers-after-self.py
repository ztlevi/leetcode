class Solution(object):
    def countSmaller(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        if not nums:
            return []
        mx = max(nums)
        mi = min(nums)

        res = [0] * len(nums)
        idx = len(nums) - 1
        tree = [0] * (mx - mi + 2)
        for i in range(len(nums)-1, -1, -1):
            n = nums[i]
            res[idx] = self.getCount(n - mi, tree)
            idx -= 1
            self.update(n - mi+1, tree)
        return res

    def getCount(self, n, tree):
        cnt = 0
        while n > 0:
            cnt += tree[n]
            n -= n & (-n)
        return cnt

    def update(self, n, tree):
        while n < len(tree):
            tree[n] += 1
            n += n & (-n)

# so = Solution()
# print(so.countSmaller([5,2,1,6]))