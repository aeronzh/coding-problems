package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * In this version of "Bot saves princess", Princess Peach and bot's position
 * are randomly set. Can you save the princess?
 * 
 * Task
 * 
 * Complete the function nextMove which takes in 4 parameters - an integer N,
 * integers r and c indicating the row & column position of the bot and the
 * character array grid - and outputs the next move the bot makes to rescue the
 * princess.
 * 
 * Input Format
 * 
 * The first line of the input is N (<100), the size of the board (NxN). The
 * second line of the input contains two space separated integers, which is the
 * position of the bot.
 * 
 * Grid is indexed using Matrix Convention
 * 
 * The position of the princess is indicated by the character 'p' and the
 * position of the bot is indicated by the character 'm' and each cell is
 * denoted by '-' (ascii value: 45).
 * 
 * Output Format
 * 
 * Output only the next move you take to rescue the princess. Valid moves are
 * LEFT, RIGHT, UP or DOWN
 * 
 * @author lucas
 *
 */
public class SavePrincess2 {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		char[][] grid = new char[n][n];
		int mr = 0, mc = 0, pr = 0, pc = 0;
		mr = scanner.nextInt();
		mc = scanner.nextInt();

		for (int i = 0; i < n; i++) {
			String line = scanner.next();
			grid[i] = line.toCharArray();

			if (line.contains("p")) {
				pc = line.indexOf("p");
				pr = i;
			}
		}

		String dirUD = (pr > mr) ? "DOWN" : "UP";
		String dirLR = (pc > mc) ? "RIGHT" : "LEFT";

		if (Math.abs(pr - mr) > 0) {
			System.out.println(dirUD);
			return;
		}

		if (Math.abs(pc - mc) > 0) {
			System.out.println(dirLR);
			return;
		}
	}
}
