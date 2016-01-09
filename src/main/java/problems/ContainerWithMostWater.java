package problems;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * @author lucas
 *
 */

//          |
//          |        |
//       |  |        |        |
// |  |  |  |  |  |  |  |  |  |
//{1, 1, 2, 4, 1, 1, 3, 1, 1, 2} ==> 2 and 2 == 14
public class ContainerWithMostWater {

    // O(n^2)
    public static int solveNaive(int[] a) {
        int max = 0;

        for (int i=0; i<a.length; i++) {
            for (int c=0; c<a.length; c++) {
                if (c!=i) {
                    max = Math.max(max, (c - i)*Math.min(a[c], a[i]));
                }
            }
        }

        return max;
    }


	public static int solve(int[] a) {
		int left = 0;
		int right = a.length-1;
		int max= 0;
		
		while (left < right) {
            if (a[left] <= a[right]) {
				left++;
			} else {
				right--;
			}

			max = Math.max(max, (right - left)*Math.min(a[left], a[right]));
		}

		return max;
	}

	public static void main(String[] args) {
		int[] a = {1, 1, 2, 4, 1, 1, 3, 1, 1, 2};
		System.out.println(solve(a));
        System.out.println(solveNaive(a));
	}

}
