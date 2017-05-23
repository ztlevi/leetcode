# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def verticalOrder(self, root):
        import math
        import collections
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        cols = collections.defaultdict(list)
        queue = collections.deque([(root, 0)])

        while queue:
            node, i = queue.popleft()
            if node:
                cols[i].append(node.val)
                queue += (node.left, i-1), (node.right, i+1)

        return [cols[i] for i in sorted(cols)]