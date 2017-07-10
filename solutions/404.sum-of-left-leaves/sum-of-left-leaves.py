# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def sumOfLeftLeaves(self, root):
        """
        :type root: TreeNode
        :rtype: int
        """
        if not root:
            return 0
        sum = 0
        q = collections.deque([root])
        while q:
            node = q.popleft()
            if node.left:
                if not node.left.left and not node.left.right:
                    sum += node.left.val
                q.append(node.left)
            if node.right:
                q.append(node.right)
        return sum