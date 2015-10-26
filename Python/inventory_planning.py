import random

def inventory_planning(d, m, c, h):
    n = len(d)
    D = sum(d)
    C = [[0 for j in range(D + 1)] for i in range(n)]
    M = [[0 for j in range(D + 1)] for i in range(n)]
    for i in range(n):
        Di = sum(d[:i+1])
        Di1 = sum(d[:i])
        for j in range(Di, D + 1):
            tmin = -1
            tk = -1
            for k in range(Di1, j + 1):
                if i == 0:
                    cost = (j - m) * c
                else:
                    cost = (j - k - m) * c
                if cost < 0:
                    cost = 0
                if i == 0:
                    cost += h[j-sum(d[:i+1])]
                else:
                    cost += C[i-1][k] + h[j-sum(d[:i+1])]
                if tmin < 0 or tmin > cost:
                    tmin = cost
                    tk = k
            C[i][j] = tmin
            M[i][j] = tk
    for r in C:
        print r
    print
    for r in M:
        print r
    return C[n-1][D]

if __name__ == '__main__':
    n = 6
    d = [random.randint(0, 10) for i in range(n)]
    h = [random.randint(1, 5) for i in range(sum(d)+1)]
    h.sort()
    h[0] = 0
    m = 3
    c = 2
    print d
    print m
    print c
    print h
    print
    print inventory_planning(d, m, c, h)
