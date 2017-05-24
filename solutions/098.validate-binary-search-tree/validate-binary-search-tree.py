# # Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None


class Solution(object):
    def isValidBST(self, root):
        """
        :type root: TreeNode
        :rtype: bool
        """
        if not root:
            return True
        else:
            return self.dfs(root, float('-inf'), float('inf'))

    def dfs(self, root, minimum, maximum):
        if root == None:
            return True
        if root.val >= maximum or root.val <= minimum:
            return False
        else:
            return self.dfs(root.left, minimum, root.val) and self.dfs(root.right, root.val, maximum)


# root = TreeNode(2)
# root.left = TreeNode(1)
# root.right = TreeNode(3)
# so = Solution()
# so.isValidBST(root)
