# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def isSubtree(self, s, t):
        """
        :type s: TreeNode
        :type t: TreeNode
        :rtype: bool
        """
        ss = self.tree2String(s)
        st = self.tree2String(t)
        if ss.find(st) != -1:
            return True
        else:
            return False
        
    def tree2String(self, t):
        if not t:
            return ''
        l = self.tree2String(t.left)
        r = self.tree2String(t.right)
        s = ',' + str(t.val)
        if l:
            s += ',' + l
        else:
            s += ',#'
        if r:
            s += ',' + r
        else:
            s += ',#'
        return s
        