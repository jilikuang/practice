def diff_ways_to_calc(s):
    ans = []
    for i in range(len(s)):
        if s[i] == '+' or s[i] == '-' or s[i] == '*':
            A = diff_ways_to_calc(s[:i])
            B = diff_ways_to_calc(s[i+1:])
            for x in A:
                for y in B:
                    t = 0
                    if s[i] == '+':
                        t = x + y
                    elif s[i] == '-':
                        t = x - y
                    elif s[i] == '*':
                        t = x * y
                    ans.append(t)
    if not ans:
        ans.append(int(s))
    return ans

if __name__ == '__main__':
    #s = '2-1-1'
    s = '2*3-4*5'
    print diff_ways_to_calc(s)
