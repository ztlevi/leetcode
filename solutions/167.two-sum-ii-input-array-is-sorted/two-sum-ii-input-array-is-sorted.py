class Solution(object):
    def twoSum(self, numbers, target):
        """
        :type numbers: List[int]
        :type target: int
        :rtype: List[int]
        """
        dic = {} # target - n : i
        for i in range(len(numbers)):
            n = numbers[i]
            if n in dic:
                return [dic[n], i + 1]
            else:
                dic[target - n] = i + 1
        return []
                