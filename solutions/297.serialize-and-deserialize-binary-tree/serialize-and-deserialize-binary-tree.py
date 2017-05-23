# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Codec:

    def serialize(self, root):
        """Encodes a tree to a single string.
        
        :type root: TreeNode
        :rtype: str
        """
        rst = []
        if root:
            rst.append(root.val)
        else:
            return rst
        lastNodelist = [root]
        nullCount = 0
        while lastNodelist:
            nodelist = []
            for node in lastNodelist:
                if node.left:
                    rst.append(node.left.val)
                    nodelist.append(node.left)
                    nullCount = 0
                else:
                    rst.append(None)
                    nullCount += 1

                if node.right:
                    rst.append(node.right.val)
                    nodelist.append(node.right)
                    nullCount = 0
                else:
                    rst.append(None)
                    nullCount += 1

            lastNodelist = nodelist

        return rst[:-1*nullCount]
        

    def deserialize(self, data):
        """Decodes your encoded data to tree.
        
        :type data: str
        :rtype: TreeNode
        """
        lastNodelist = []
        root = None
        if data:
            root = TreeNode(data[0])
            lastNodelist.append(root)
        else:
            return None
        dataLen = len(data)
        idx = 1
        while lastNodelist:
            nodelist = []
            for node in lastNodelist:
                if idx < dataLen:
                    if data[idx] != None:
                        node.left = TreeNode(data[idx])
                        nodelist.append(node.left)
                else:
                    break

                idx += 1
                if idx < dataLen:
                    if data[idx] != None:
                        node.right = TreeNode(data[idx])
                        nodelist.append(node.right)
                else:
                    break
                idx += 1
            lastNodelist = nodelist
        return root
