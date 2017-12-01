class Solution(object):
    def nextGreaterElement(self, findNums, nums):
        """
        :type findNums: List[int]
        :type nums: List[int]
        :rtype: List[int]
        """
        dic = {}
        stack = []
        for n in nums[::-1]:
            
            while stack and stack[-1] < n:
                stack.pop()
            if not stack:
                dic[n] = -1
            else:
                dic[n] = stack[-1]
            stack.append(n)
        
        res = []
        for n in findNums:
            res.append(dic[n])
        return res
