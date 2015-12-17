package problems;

public class SolveBoardGame {

	public static boolean check(int[] a, int start) {
		if (start == a.length) {
			return true;
		} else {
			for (int c = 1; c <= a[start]; c++) {
				if (check(a, (start + c))) {
					return true;
				}
			}
			return false;
		}
	}

	public static void main(String[] args) {
		int[] a1 = { 3, 3, 1, 0, 2, 0, 1 };
		int[] a2 = { 3, 2, 0, 1, 2, 0, 0, 3 };
		System.out.println(check(a1, 0));
	}

}
