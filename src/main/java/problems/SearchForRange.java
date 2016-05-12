package problems;

/**
 * Given a sorted array of integers, find the starting and ending position of a
 * given target value. Your algorithm's runtime complexity must be in the order
 * of O(log n). If the target is not found in the array, return [-1, -1]. For
 * example, given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 * 
 * @author lucas
 *
 */
public class SearchForRange {

	public static int[] solve(int[] array, int n, int start, int end, int foundStart, int foundEnd) {
		int[] pos = new int[]{foundStart, foundEnd};
		
		if (start<end) {
			int middle = (start + end)/2;
			if (array[middle] == n) {
				// found
				if (middle<foundStart) {
					foundStart = middle;
				}
				if (middle>foundEnd) {
					foundEnd = middle;
				}
				pos = new int[]{foundStart, foundEnd};
				
				int[] tl = solve(array, n, 0, middle, foundStart, foundEnd);
				if (tl[0]<pos[0]) {
					pos[0] = tl[0];
				}
				int[] tr = solve(array, n, middle+1, end, foundStart, foundEnd);
				if (tr[1]>pos[1]) {
					pos[1] = tr[1];
				}
			} else if (n<array[middle]) {
				// go left
				pos = solve(array, n, 0, middle, foundStart, foundEnd);
			} else {
				// go right
				pos = solve(array, n, middle+1, end, foundStart, foundEnd);
			}
		}
		
		
		return pos;
	}
	
	
	public static void main(String[] args) {
		int[] array = new int[]{5, 7, 7, 8, 8, 10};
		int n = 8;
		int[] position = solve(array, n, 0, array.length-1, array.length, -1);
		System.out.println("start="+position[0]);
		System.out.println("end="+position[1]);
	}

}
