class TreeNode(object):
    def __init__(self, c=None):
        self.isword = False
        self.children = {}
        self.char = c

class WordDictionary(object):
    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.root = TreeNode()

    def addWord(self, word):
        """
        Adds a word into the data structure.
        :type word: str
        :rtype: void
        """
        node = self.root
        for c in word:
            if not c in node.children:
                node.children[c] = TreeNode(c)
            node = node.children[c]
        node.isword = True

    def search(self, word):
        """
        Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
        :type word: str
        :rtype: bool
        """

        def dfs(word, node):
            c, word = word[0], word[1:]

            if not word:
                if c == '.':
                    for child in node.children:
                        if node.children[child].isword:
                            return True
                    return False
                else:
                    return c in node.children and node.children[c].isword

            if c == '.':
                for child in node.children:
                    if dfs(word, node.children[child]):
                        return True
                return False
            else:
                if c in node.children:
                    return dfs(word, node.children[c])
                else:
                    return False

        return dfs(word, self.root)

