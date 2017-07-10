# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None
# import collections
class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        :type root: TreeNode
        :rtype: str
        """
        if not root:
            return []
        rst = [str(root.val)]
        queue = collections.deque([root])
        while queue:
            node = queue.popleft()
            if node.left:
                rst.append(str(node.left.val))
                queue.append(node.left)
            else:
                rst.append("#")
                
            if node.right:
                rst.append(str(node.right.val))
                queue.append(node.right)
            else:
                rst.append("#")

        return ' '.join(rst)

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        if not data:
            return None
        vals = iter(data.split())
        val = vals.next()
        root = TreeNode(int(val))
        queue = collections.deque([root])
        while queue:
            node = queue.popleft()
            val = vals.next()
            if val == '#':
                node.left = None
            else:
                node.left = TreeNode(int(val))
                queue.append(node.left)
                
            val = vals.next()
            if val == '#':
                node.right = None
            else:
                node.right = TreeNode(int(val))
                queue.append(node.right)
        return root

# Your Codec object will be instantiated and called as such:
# codec = Codec()
# codec.deserialize("2 1 3")
#codec.deserialize(codec.serialize(root))
