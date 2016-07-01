public class SavePrincess {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		char[][] grid = new char[n][n];
		int mr = 0, mc = 0, pr = 0, pc = 0;
		for (int i = 0; i < n; i++) {
			String line = scanner.next();
			grid[i] = line.toCharArray();

			if (line.contains("m")) {
				mc = line.indexOf("m");
				mr = i;
			}

			if (line.contains("p")) {
				pc = line.indexOf("p");
				pr = i;
			}
		}

		String dirUD = (pr > mr) ? "DOWN" : "UP";
		String dirLR = (pc > mc) ? "RIGHT" : "LEFT";

		for (int i=0; i<Math.abs(pr - mr); i++) {
			System.out.println(dirUD);
		}
		
		for (int i=0; i<Math.abs(pc - mc); i++) {
			System.out.println(dirLR);
		}
	}
}
