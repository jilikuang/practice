import random

def maximial_rectangle(matrix):
    if not matrix or not matrix[0]:
        return 0
    m = len(matrix)
    n = len(matrix[0])
    lefts = [0 for j in range(n)]
    rights = [n for j in range(n)]
    heights = [0 for j in range(n)]
    max_area = 0
    for i in range(m):
        left, right = 0, n
        for j in range(n):
            if matrix[i][j] == 1:
                lefts[j] = max(lefts[j], left)
                heights[j] += 1
            else:
                lefts[j] = 0
                left = j + 1
                heights[j] = 0
            r = n - j
            if matrix[i][r-1] == 1:
                rights[r-1] = min(rights[r-1], right)
            else:
                rights[r-1] = n
                right = r - 1
        for j in range(n):
            max_area = max(max_area, (rights[j] - lefts[j]) * heights[j])
    return max_area

if __name__ == '__main__':
    m = 5
    n = 5
    matrix = [[random.randint(0,1) for j in range(n)] for i in range(m)]
    for r in matrix:
        print r
    print maximial_rectangle(matrix)
