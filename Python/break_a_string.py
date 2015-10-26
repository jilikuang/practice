def print_break(L, o, i, j):
    k = o[i][j]
    if k == 0:
        return
    print L[k]
    print_break(L, o, i, k)
    print_break(L, o, k, j)

def break_a_string(s, L):
    n = len(s)
    Ln = [0] + L + [n]
    c = [[0 for j in range(len(Ln))] for i in range(len(Ln))]
    o = [[0 for j in range(len(Ln))] for i in range(len(Ln))]
    for i in range(1, len(Ln)):
        c[i-1][i] = 0
    for l in range(2, len(Ln)):
        for i in range(len(Ln) - l):
            j = i + l
            m = -1
            tk = -1
            for k in range(i + 1, j):
                t = c[i][k] + c[k][j] + Ln[j] - Ln[i]
                if m < 0 or m > t:
                    m = t
                    tk = k
            c[i][j] = m
            o[i][j] = tk
    print n
    print Ln
    print
    for l in c:
        print l
    print
    for l in o:
        print l
    print_break(Ln, o, 0, len(Ln)-1)

if __name__ == '__main__':
    s = 'This is a test strin'
    L = [1, 8, 10]
    print break_a_string(s, L)
