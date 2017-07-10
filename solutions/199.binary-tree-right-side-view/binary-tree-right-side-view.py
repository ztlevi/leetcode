from collections import deque
# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        if not root:
            return []
        lastLevel = deque([root])
        nextLevel = deque([])
        rst = []

        while lastLevel:
            node = lastLevel.popleft()
            if node.left:
                nextLevel.append(node.left)
            if node.right:
                nextLevel.append(node.right)
            if not lastLevel:
                rst.append(node.val)
                lastLevel = nextLevel
                nextLevel = deque([])
                continue
        return rst
    