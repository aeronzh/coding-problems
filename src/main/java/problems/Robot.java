package problems;

public class Robot {
	private static int count = 0;
	/**
	 * List all possibles paths from (0,0) to (m-1, n-1). Allowed moves right, down, diagonal down. Only cells with '1' are alowed to be visited.
	 * @param map
	 * @return
	 */
//	1 1 1
//	0 0 1
//	0 0 1
	public static int move(int[][] map, int r, int c, int endr, int endc) {
		int height = map.length;
		int width = map[0].length;
		
		if (r==endr && c==endc) {
			count++;
			System.out.println("Reached destination");
		} else {
			if (c<width-1 && map[r][c+1]==1) {
				// Go right
				move(map, r, c+1, endr, endc);
			}
			
			if (r<height-1 && map[r+1][c]==1) {
				// Go down
				move(map, r+1, c, endr, endc);
			}
			
			if (c<width-1 && r<height-1 && map[r+1][c+1]==1) {
				// Go diagonal down
				move(map, r+1, c+1, endr, endc);
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		int[][] map = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 1 } };
		//int[][] map = { { 1, 1 }, { 0, 0}, { 0, 0 } };
		int height = map.length;
		int width = map[0].length;
		
		move(map, 0, 0, height-1, width-1);
		System.out.println(count);
	}

}
