def ladderLength(beginWord, endWord, wordDict):
    length = 1
    queue = [beginWord]
    wordDict.remove(beginWord)
    wordDict.remove(endWord)
    while queue:
        newQueue = []
        for w in queue:
            for i in range(len(w)):
                wL = list(w)
                for c in range(ord('a'), ord('z') + 1):
                    wL[i] = chr(c)
                    wC = ''.join(wL)
                    if wC == endWord:
                        return length + 1
                    if wC in wordDict:
                        newQueue.append(wC)
                        wordDict.remove(wC)
        queue = newQueue
        length += 1
    return 0

if __name__ == '__main__':
    begin = 'hot'
    end = 'dog'
    words = set()
    words.add('dog')
    words.add('hot')
    words.add('dot')
    print ladderLength(begin, end, words)
