class WordDict(object):

    class TrieNode:

        def __init__(self, char='$'):
            self._char = char
            if char == '$':
                self._next = None
            else:
                self._next = {}

    def __init__(self):
        self._nodes = {}

    def add(self, word):
        nodes = self._nodes
        for c in word:
            if c not in nodes:
                nodes[c] = self.TrieNode(c)
            nodes = nodes[c]._next
        nodes['$'] = self.TrieNode('$')

    def search(self, word, nodes=None):
        if not nodes:
            nodes = self._nodes

        if not word:
            if '$' in nodes:
                return True
            return False

        if word[0] == '.':
            for c in nodes:
                if nodes[c]._next and self.search(word[1:], nodes[c]._next):
                    return True
            return False
        elif word[0] not in nodes:
            return False
        else:
            return self.search(word[1:], nodes[word[0]]._next)

if __name__ == '__main__':
    wd = WordDict()
    wd.add('ran')
    print wd.search('.......')
