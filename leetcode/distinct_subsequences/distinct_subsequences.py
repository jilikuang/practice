def distinct_subsequences(S, T):
    ls = len(S)
    lt = len(T)
    if ls < lt:
        return 0
    c = [[0 for j in range(ls+1)] for i in range(lt+1)]
    for j in range(ls+1):
        c[0][j] = 1
    for i in range(1, lt+1):
        for j in range(1, ls+1):
            c[i][j] = c[i][j-1]
            if S[j-1] == T[i-1]:
                c[i][j] += c[i-1][j-1]
    return c[lt][ls]

if __name__ == '__main__':
    S = 'aab'
    T = 'ab'
    print distinct_subsequences(S, T)
