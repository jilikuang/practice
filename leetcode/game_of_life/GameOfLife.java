import java.util.Random;
import java.util.Arrays;

class GameOfLife {
	public void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++)
			System.out.println(Arrays.toString(board[i]));
	}

	public void nextState(int[][] board) {
		if (board.length == 0 || board[0].length == 0)
			return;

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int liveCount = 0;
				for (int x = i - 1; x <= i + 1; x++) {
					if (x < 0 || x >= m)
						continue;
					for (int y = j - 1; y <= j + 1; y++) {
						if (y < 0 || y >= n)
							continue;
						if (x == i && y == j)
							continue;
						if ((board[x][y] & 1) == 1)
							liveCount++;
					}
				}
				if ((board[i][j] & 1) == 0) {
					if (liveCount == 3)
						board[i][j] |= 2;
				} else {
					if (liveCount == 2 || liveCount == 3)
						board[i][j] |= 2;
				}
			}
		}

		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				board[i][j] >>= 1;
	}

	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Not enough arguments");
			return;
		}

		int m = Integer.parseInt(args[0]);
		int n = Integer.parseInt(args[1]);
		int[][] board = new int[m][n];
		Random r = new Random();
		GameOfLife g = new GameOfLife();

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = r.nextInt(2);
			}
		}

		System.out.println("Current state:");
		g.printBoard(board);
		g.nextState(board);
		System.out.println("Next state:");
		g.printBoard(board);
	}
}
