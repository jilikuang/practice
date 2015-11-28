import copy

def extend_shortest_paths(L, W):
    n = len(L)
    Lnew = [['#' for i in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            for k in range(n):
                if L[i][k] != '#' and W[k][j] != '#':
                    if Lnew[i][j] == '#':
                        Lnew[i][j] = L[i][k] + W[k][j]
                    else:
                        Lnew[i][j] = min(Lnew[i][j], L[i][k] + W[k][j])
    return Lnew

def slow_all_pairs_shortest_paths(W):
    n = len(W)
    L = copy.deepcopy(W)
    for m in range(2, n):
        L = extend_shortest_paths(L, W)
    return L

def FloydWarshall(W):
    n = len(W)
    D = copy.deepcopy(W)
    P = [['#' for i in range(n)] for i in range(n)]
    for i in range(n):
        for j in range(n):
            if D[i][j] != '#':
                P[i][j] = i
    for k in range(n):
        Dnew = [['#' for i in range(n)] for i in range(n)]
        Pnew = [['#' for i in range(n)] for i in range(n)]
        for i in range(n):
            for j in range(n):
                if D[i][k] != '#' and D[k][j] != '#':
                    if D[i][j] == '#':
                        Dnew[i][j] = D[i][k] + D[k][j]
                        if i != j:
                            Pnew[i][j] = P[k][j]
                    else:
                        Dnew[i][j] = min(D[i][j], D[i][k] + D[k][j])
                        if i != j:
                            if Dnew[i][j] == D[i][j]:
                                Pnew[i][j] = P[i][j]
                            else:
                                Pnew[i][j] = P[k][j]
                elif D[i][j] != '#':
                    Dnew[i][j] = D[i][j]
                    if i != j:
                        Pnew[i][j] = P[i][j]
        D = Dnew
        P = Pnew
    return D, P


def faster_all_pairs_shortest_paths(W):
    n = len(W)
    L = copy.deepcopy(W)
    m = 1
    while m < n - 1:
        L = extend_shortest_paths(L, L)
        m *= 2
    return L

if __name__ == '__main__':
    W = [
            [0, 3, 8, '#', -4],
            ['#', 0, '#', 1, 7],
            ['#', 4, 0, '#', '#'],
            [2, '#', -5, 0, '#'],
            ['#', '#', '#', 6, 0]]
    L = slow_all_pairs_shortest_paths(W)
    for l in L:
        print l
    print
    L = faster_all_pairs_shortest_paths(W)
    for l in L:
        print l
    print
    D, P = FloydWarshall(W)
    for d in D:
        print d
    for p in P:
        print p
