class TreeNode(object):
    def __init__(self, c = None):
        self.isword = False
        self.children = {}
        self.char = c
        
class Trie(object):
        
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TreeNode()

    def insert(self, word):
        """
        Inserts a word into the trie.
        :type word: str
        :rtype: void
        """
        node = self.root
        for c in word:
            if not c in node.children.keys():
                node.children[c] = TreeNode(c)
            node = node.children[c]
        node.isword = True

    def search(self, word):
        """
        Returns if the word is in the trie.
        :type word: str
        :rtype: bool
        """
        node = self.root
        for c in word:
            if not node.children:
                return False
            elif not c in node.children.keys():
                return False
            else:
                node = node.children[c]
        if node.isword == True:
            return True
        else:
            return False
                

    def startsWith(self, prefix):
        """
        Returns if there is any word in the trie that starts with the given prefix.
        :type prefix: str
        :rtype: bool
        """
        node = self.root
        for c in prefix:
            if not node.children or not c in node.children.keys():
                return False
            else:
                node = node.children[c]
        return True
        


# Your Trie object will be instantiated and called as such:
# obj = Trie()
# obj.insert(word)
# param_2 = obj.search(word)
# param_3 = obj.startsWith(prefix)