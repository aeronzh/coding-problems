package problems;

public class NPills {

	public static boolean valid(int turns, int size, int remain, int persons) {
		if (turns == 0) {
			return (size + remain <= 2);
		} else {
			int newRemain = (size % persons) + remain;
			int newSize = size / persons;

			return valid(turns - 1, newSize, newRemain, persons);
		}

	}

	// return minimum number of people
	public static int pills(int turns, int n) {
		int i = 1;
		while (i <= n) {
			boolean result = valid(2, n, 0, i);
			if (result == true) {
				return i;
			}	
			i++;
		}
		return n;
	}

	public static void main(String[] args) {
		System.out.println(pills(2, 1000)); // 7

		System.out.println(pills(2, 10)); // 3

		// {1, 2, 3}, {4, 5, 6}, {7, 8, 9}, 10
		// 10 - 1 = 9

		// 1 --> 0 : {1}
		// 2 --> 1 : {1}, 2
		// 3 --> 1 : {1}, 2, 3
		// 4 --> 2 : {1, 2}, {3, 4}
		// 5 --> 2 : {1, 2}, {3, 4}, 5
		// 6 --> 2 : {1, 2}, {3, 4}, 5, 6
		// 7 --> 2 : {1, 2}, {3, 4}, 5, 6, 7
		// 8 --> 2 : {1 ,2, 3}, {4, 5, 6}, 7, 8
		// 9 --> 3 : {1 ,2 ,3}, {4, 5 ,6}, {7, 8, 9}
		// 10 --> 3: {1 ,2 ,3}, {4, 5 ,6}, {7, 8, 9}, 10

		// Strategy: divide into x groups so that after being divided t times by x result to a remainder of 1 (%).

	}

}
