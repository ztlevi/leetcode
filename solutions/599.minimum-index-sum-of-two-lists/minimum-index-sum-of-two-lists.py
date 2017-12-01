class Solution(object):
    def findRestaurant(self, list1, list2):
        """
        :type list1: List[str]
        :type list2: List[str]
        :rtype: List[str]
        """
        dic = collections.defaultdict(list)
        for i in range(len(list1)):
            dic[list1[i]].append(i)
        for i in range(len(list2)):
            dic[list2[i]].append(i)
        sum = float('inf')
        rst = []
        for restaurant, l in dic.items():
            if len(l) == 2:
                curSum = l[0] + l[1]
                if curSum < sum:
                    sum = curSum
                    rst = [restaurant]
                elif curSum == sum:
                    rst.append(restaurant)
        return rst