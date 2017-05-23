# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def helper(self, root, path, rst):
        if root.left is None and root.right is None:
            rst.append(path)
            return
        if root.left:
            self.helper(root.left, path + "->" + str(root.left.val), rst)
        if root.right:
            self.helper(root.right, path + "->" + str(root.right.val), rst)
            
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        rst = []
        if not root:
            return []
        if root.val:
            self.helper(root, str(root.val), rst)
        return rst
                    
    