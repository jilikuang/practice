def minimum_window_substring(s, t):
    nums = {}
    counts = {}
    for c in t:
        if c in nums:
            nums[c] += 1
        else:
            nums[c] = 1
        if c not in counts:
            counts[c] = 0
    pool = set(t)
    start, end = 0, len(s)
    i = 0
    for j in range(len(s)):
        if s[j] in t:
            counts[s[j]] += 1
            if s[j] in pool and counts[s[j]] == nums[s[j]]:
                pool.remove(s[j])
            while not pool:
                if s[i] in t:
                    if counts[s[i]] == nums[s[i]]:
                        if j - i + 1 < end - start + 1:
                            start = i
                            end = j
                        pool.add(s[i])
                    counts[s[i]] -= 1
                i += 1
    if end == len(s):
        return ''
    return s[start:end+1]

if __name__ == '__main__':
    s = 'bdab'
    t = 'ab'
    print s, t
    print minimum_window_substring(s, t)
