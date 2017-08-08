class Solution(object):
    def isStrobogrammatic(self, num):
        """
        :type num: str
        :rtype: bool
        """
        pair = {'1':'1', '6':'9', '9':'6', '0':'0', '8':'8'}
        for i in range(len(num)/2 + 1):
            if num[i] not in pair or pair[num[i]] != num[~i]: return False
        return True
                
        