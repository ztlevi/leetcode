# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def longestConsecutive(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        self.maximal = 1
        def dfs(root, cnt):
            if not root:
                return
            if root.left:
                if root.left.val == root.val + 1:
                    dfs(root.left, cnt+1)
                    self.maximal = max(self.maximal, cnt+1)
                else:
                    dfs(root.left, 1)
            if root.right:
                if root.right.val == root.val + 1:
                    dfs(root.right, cnt+1)
                    self.maximal = max(self.maximal, cnt+1)
                else:
                    dfs(root.right, 1)
        dfs(root, 1)
        return self.maximal