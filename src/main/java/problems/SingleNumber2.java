package problems;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * @author lucas
 *
 */
public class SingleNumber2 {

	public static int singleNumber(int[] A) {
	    int ones = 0, twos = 0, threes = 0;
	    for (int i = 0; i < A.length; i++) {
	        twos |= ones & A[i];
	        ones ^= A[i];
	        threes = ones & twos;
	        ones &= ~threes;
	        twos &= ~threes;
	    }
	    return ones;
	}
	

	public static void main(String[] args) {
		int[] array = { 1, 3, 4, 1, 3, 4, 2, 2, 2, 5, 6, 6, 6, 1, 3, 4 }; // 5
		System.out.println(singleNumber(array));
	}

}
