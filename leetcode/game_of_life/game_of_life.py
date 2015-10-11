def sumOfNeighbors(board, i, j):
    sum = 0

    for m in range(3):
        x = i - 1 + m
        if x < 0 or x >= len(board):
            continue
        for n in range(3):
            y = j - 1 + n
            if y < 0 or y >= len(board[i]):
                continue
            if x == i and y == j:
                continue
            if board[x][y] > 0:
                sum += 1
    return sum

def gameOfLife(board):
    if not board or not board[0]:
        return
    for i in range(len(board)):
        for j in range(len(board[i])):
            n = sumOfNeighbors(board, i, j)
            if board[i][j] > 0 and (n < 2 or n > 3):
                board[i][j] = 2
            elif board[i][j] < 1 and n == 3:
                board[i][j] = -1
    for i in range(len(board)):
        for j in range(len(board[0])):
            if board[i][j] > 1:
                board[i][j] = 0
            elif board[i][j] < 0:
                board[i][j] = 1

if __name__ == '__main__':
    board = [[1,1]]
    print 'curr: ' + str(board)
    gameOfLife(board)
    print 'next: ' + str(board)
