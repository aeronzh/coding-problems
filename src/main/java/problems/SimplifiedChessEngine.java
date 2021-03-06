package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SimplifiedChessEngine {
	private static final int EMPTY = 0;
	private static final int ROWS = 4;
	private static final int COLUMNS = 4;
	private static final int WHITE = 1;
	private static final int BLACK = 0;

	// Odd is White
	private static final int QUEEN_W = 1;
	private static final int KNIGHT_W = 3;
	private static final int BISHOP_W = 5;
	private static final int ROOK_W = 7;

	// Even is Black
	private static final int QUEEN_B = 2;
	private static final int KNIGHT_B = 4;
	private static final int BISHOP_B = 6;
	private static final int ROOK_B = 8;

	// Movements
	private static final int[] queenR = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private static final int[] queenC = { -1, 0, 1, -1, 1, -1, 0, 1 };

	private static final int[] knightR = { -2, -2, -1, -1, 1, 1, 2, 2 };
	private static final int[] knightC = { -1, 1, -2, 2, -2, 2, -1, 1 };

	private static final int[] bishopR = { -1, -1, 1, 1 };
	private static final int[] bishopC = { -1, 1, -1, 1 };

	private static final int[] rookR = { -1, 0, 0, 1 };
	private static final int[] rookC = { 0, -1, 1, 0 };

	private static int characterW2Int(char t) {
		switch (t) {
		case 'Q':
			return QUEEN_W;
		case 'N':
			return KNIGHT_W;
		case 'B':
			return BISHOP_W;
		default:
			return ROOK_W;
		}
	}

	private static int characterB2Int(char t) {
		switch (t) {
		case 'Q':
			return QUEEN_B;
		case 'N':
			return KNIGHT_B;
		case 'B':
			return BISHOP_B;
		default:
			return ROOK_B;
		}
	}

	private static String int2Character(int t) {
		if (t == QUEEN_W || t == QUEEN_B) {
			return "Q";
		}

		if (t == KNIGHT_W || t == KNIGHT_B) {
			return "N";
		}

		if (t == BISHOP_W || t == BISHOP_B) {
			return "B";
		}

		if (t == ROOK_W || t == ROOK_B) {
			return "R";
		}

		return "";
	}

	/**
	 * Convert an int[][] board to the appropriate input.
	 *
	 * @param board
	 * @param w
	 * @param b
	 * @param m
	 * @return
	 */
	private static String boardToInput(int[][] board, int w, int b, int m) {
		StringBuilder sb = new StringBuilder();
		StringBuilder white = new StringBuilder();
		StringBuilder black = new StringBuilder();

		sb.append(w + " " + b + " " + m + "\n");
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				String t = int2Character(board[r][c]);
				if (!"".equals(t)) {
					if (board[r][c] % 2 == WHITE) {
						white.append(t + " " + (char) (c + 'A') + " " + (4 - r) + "\n");
					} else {
						black.append(t + " " + (char) (c + 'A') + " " + (4 - r) + "\n");
					}
				}
			}
		}

		sb.append(white);
		sb.append(black);

		return sb.toString();
	}

	/**
	 * Return int[][] board as String.
	 *
	 * @param board
	 */
	private static void print(int[][] board) {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	private static String state(int[][] board, int m, int player) {
		StringBuilder sb = new StringBuilder();
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				sb.append(board[r][c]);
			}
			sb.append(" ");
		}
		sb.append(m + " " + player);
		return sb.toString();
	}

	private static void move(int[][] board, int sr, int sc, int tr, int tc) {
		board[tr][tc] = board[sr][sc];
		board[sr][sc] = EMPTY;
	}

	private static boolean isWithinLimits(int r, int c) {
		// we are within limits
		return ((r >= 0 && r < ROWS) && (c >= 0 && c < COLUMNS));
	}

	private static boolean isValid(int[][] board, int r, int c, int player) {
		// we are within limits AND (it is empty OR occupied by opponent)
		return (isWithinLimits(r, c) && (board[r][c] == EMPTY || (board[r][c] != EMPTY && board[r][c] % 2 != player)));
	}

	private static boolean isWinForPlayer(int[][] board, int player) {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				if (board[r][c] == (player == WHITE ? QUEEN_B : QUEEN_W)) {
					return false;
				}
			}
		}

		return true;
	}

	private static int[] queen(int[][] board, int player) {
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				if (board[r][c] != EMPTY && board[r][c] % 2 == player && (board[r][c] == QUEEN_W || board[r][c] == QUEEN_B)) {
					return new int[] { r, c };
				}
			}
		}

		return new int[] { -1, -1 };
	}

	private static boolean isQueenSafeForPlayer(int[][] board, int player) {
		int[] queen = queen(board, player);
		int qr = queen[0];
		int qc = queen[1];

		if (qr == -1 && qc == -1) {
			// Player has no Queen on board --> Lost
			return false;
		}

		if (player == WHITE && isWinForPlayer(board, WHITE)) {
			return true;
		}

		if (player == BLACK && isWinForPlayer(board, BLACK)) {
			return true;
		}

		// Check if opponent's Queen is in the way
		for (int dir = 0; dir < queenR.length; dir++) {
			LEN: for (int len = 1; len < 4; len++) {
				int tr = qr + queenR[dir] * len;
				int tc = qc + queenC[dir] * len;

				if (isWithinLimits(tr, tc) && (board[tr][tc] % 2 != player) && (board[tr][tc] == QUEEN_B || board[tr][tc] == QUEEN_W)) {
					// There is a Queen that does not belong to us
					return false;
				}

				if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
					// A piece is in the way
					break LEN;
				}
			}
		}

		// Check if opponent's Knight is in the way
		for (int dir = 0; dir < knightR.length; dir++) {
			int tr = qr + knightR[dir];
			int tc = qc + knightC[dir];
			if (isWithinLimits(tr, tc) && (board[tr][tc] % 2 != player) && (board[tr][tc] == KNIGHT_B || board[tr][tc] == KNIGHT_W)) {
				// There is a Knight that does not belong to us
				return false;
			}
		}

		// Check if opponent's Bishop is in the way
		for (int dir = 0; dir < bishopR.length; dir++) {
			LEN: for (int len = 1; len < 4; len++) {
				int tr = qr + bishopR[dir] * len;
				int tc = qc + bishopC[dir] * len;
				if (isWithinLimits(tr, tc) && (board[tr][tc] % 2 != player) && (board[tr][tc] == BISHOP_B || board[tr][tc] == BISHOP_W)) {
					// There is a Bishop that does not belong to us
					return false;
				}
				if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
					// A piece is in the way
					break LEN;
				}
			}
		}

		// Check if opponent's Rook is in the way
		for (int dir = 0; dir < rookR.length; dir++) {
			LEN: for (int len = 1; len < 4; len++) {
				int tr = qr + rookR[dir] * len;
				int tc = qc + rookC[dir] * len;
				if (isWithinLimits(tr, tc) && (board[tr][tc] % 2 != player) && (board[tr][tc] == ROOK_B || board[tr][tc] == ROOK_W)) {
					// There is a Rook that does not belong to us
					return false;
				}
				if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
					// A piece is in the way
					break LEN;
				}
			}
		}

		return true;
	}

	private static boolean canWhiteWin(int[][] board, int m, int player) {
		if (isWinForPlayer(board, WHITE)) {
			return true;
		}

		if (isWinForPlayer(board, BLACK)) {
			return false;
		}

		if (m <= 0) {
			return false;
		}

		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLUMNS; c++) {
				if (board[r][c] != EMPTY && board[r][c] % 2 == player) {

					if ((player == WHITE && board[r][c] == QUEEN_W) || (player == BLACK && board[r][c] == QUEEN_B)) {
						for (int dir = 0; dir < queenR.length; dir++) {
							LEN: for (int len = 1; len < 4; len++) {
								int tr = r + queenR[dir] * len;
								int tc = c + queenC[dir] * len;

								if (isValid(board, tr, tc, player)) {
									int tmp = board[tr][tc];
									move(board, r, c, tr, tc);

									if (isQueenSafeForPlayer(board, player)) {
										// Recursive call
										if (player == WHITE) {
											if (canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return true;
											}
										} else {
											if (!canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return false;
											}
										}
									}

									// Move back
									move(board, tr, tc, r, c);
									board[tr][tc] = tmp;

								}

								if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
									// A piece is in the way
									break LEN;
								}
							}
						}
					}

					if ((player == WHITE && board[r][c] == KNIGHT_W) || (player == BLACK && board[r][c] == KNIGHT_B)) {
						for (int dir = 0; dir < knightR.length; dir++) {
							int tr = r + knightR[dir];
							int tc = c + knightC[dir];

							if (isValid(board, tr, tc, player)) {
								int tmp = board[tr][tc];
								move(board, r, c, tr, tc);

								if (isQueenSafeForPlayer(board, player)) {
									// Recursive call
									if (player == WHITE) {
										if (canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
											// Move back
											move(board, tr, tc, r, c);
											board[tr][tc] = tmp;

											return true;
										}
									} else {
										if (!canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
											// Move back
											move(board, tr, tc, r, c);
											board[tr][tc] = tmp;

											return false;
										}
									}
								}

								// Move back
								move(board, tr, tc, r, c);
								board[tr][tc] = tmp;
							}
						}
					}

					if ((player == WHITE && board[r][c] == BISHOP_W) || (player == BLACK && board[r][c] == BISHOP_B)) {
						for (int dir = 0; dir < bishopR.length; dir++) {
							LEN: for (int len = 1; len < 4; len++) {
								int tr = r + bishopR[dir] * len;
								int tc = c + bishopC[dir] * len;

								if (isValid(board, tr, tc, player)) {
									int tmp = board[tr][tc];
									move(board, r, c, tr, tc);

									if (isQueenSafeForPlayer(board, player)) {
										// Recursive call
										if (player == WHITE) {
											if (canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return true;
											}
										} else {
											if (!canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return false;
											}
										}
									}

									// Move back
									move(board, tr, tc, r, c);
									board[tr][tc] = tmp;
								}

								if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
									// A piece is in the way
									break LEN;
								}
							}
						}
					}

					if ((player == WHITE && board[r][c] == ROOK_W) || (player == BLACK && board[r][c] == ROOK_B)) {
						for (int dir = 0; dir < rookR.length; dir++) {
							LEN: for (int len = 1; len < 4; len++) {
								int tr = r + rookR[dir] * len;
								int tc = c + rookC[dir] * len;

								if (isValid(board, tr, tc, player)) {
									int tmp = board[tr][tc];
									move(board, r, c, tr, tc);

									if (isQueenSafeForPlayer(board, player)) {
										// Recursive call
										if (player == WHITE) {
											if (canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return true;
											}
										} else {
											if (!canWhiteWin(board, m - 1, player == WHITE ? BLACK : WHITE)) {
												// Move back
												move(board, tr, tc, r, c);
												board[tr][tc] = tmp;

												return false;
											}
										}
									}

									// Move back
									move(board, tr, tc, r, c);
									board[tr][tc] = tmp;
								}

								if (isWithinLimits(tr, tc) && board[tr][tc] != EMPTY) {
									// A piece is in the way
									break LEN;
								}
							}
						}
					}

				}
			}
		}

		// Player was not able to make a movement. Checkmate!
		if (player == BLACK && m > 1) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		Scanner out = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		// Read input
		int games = in.nextInt();
		for (int g = 0; g < games; g++) {
			int[][] board = new int[ROWS][COLUMNS];

			int w = in.nextInt();
			int b = in.nextInt();
			int m = in.nextInt();

			for (int i = 0; i < w; i++) {
				char t = in.next().charAt(0);
				char c = in.next().charAt(0);
				int r = in.nextInt();
				board[4 - r][c - 'A'] = characterW2Int(t);
			}

			for (int i = 0; i < b; i++) {
				char t = in.next().charAt(0);
				char c = in.next().charAt(0);
				int r = in.nextInt();
				board[4 - r][c - 'A'] = characterB2Int(t);
			}

			// Keep a copy of initial board for debug purposes
			int[][] initialBoard = new int[ROWS][COLUMNS];
			for (int r = 0; r < ROWS; r++) {
				for (int c = 0; c < COLUMNS; c++) {
					initialBoard[r][c] = board[r][c];
				}
			}

			// Call algorithm
			boolean win = canWhiteWin(board, m, WHITE);
			String result = win ? "YES" : "NO";
			String expected = out.next();
			if (expected.equals(result)) {
				System.out.println(result);
			} else {
				System.out.println("ERROR: expected " + expected + " got " + result + " for input:");
				System.out.println(boardToInput(initialBoard, w, b, m));
			}
		}

	}
}
