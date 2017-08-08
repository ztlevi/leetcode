class ValidWordAbbr(object):

    def __init__(self, dictionary):
        """
        :type dictionary: List[str]
        """
        self.set = collections.defaultdict(set)
        for word in dictionary:
            if len(word) < 3:
                self.set[word].add(word)
            else:
                s = word[0] + str(len(word) - 2) + word[-1]
                self.set[s].add(word)

    def isUnique(self, word):
        """
        :type word: str
        :rtype: bool
        """
        if len(word) < 3:
            if word not in self.set or (word in self.set[word] and len(self.set[word]) == 1):
                return True
        else:
            s = word[0] + str(len(word) - 2) + word[-1]
            if s not in self.set or (word in self.set[s] and len(self.set[s]) == 1):
                return True
        return False

    
# Your ValidWordAbbr object will be instantiated and called as such:
# obj = ValidWordAbbr(dictionary)
# param_1 = obj.isUnique(word)