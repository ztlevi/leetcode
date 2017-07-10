class Solution(object):
    def subsetsWithDup(self, nums):
        """
        :type nums: List[int]
        :rtype: List[List[int]]
        """
        rst = [[]]

        nums.sort()
        l = len(rst) # store the last rst length
        
        for i in range(len(nums)):
            if i == 0 or nums[i] != nums[i-1]:
                l = len(rst)
            for j in range(len(rst) - l, len(rst)):
                rst.append(rst[j] + [nums[i]])
        return rst