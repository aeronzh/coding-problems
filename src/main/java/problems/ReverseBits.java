package problems;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * 
 * For example, given input 43261596 (represented in binary as
 * 00000010100101000001111010011100), return 15065253 (represented in binary as
 * 00111001011110000010100101000000).
 * 
 * Follow up: If this function is called many times, how would you optimize it?
 * 
 * 
 * @author lucas
 *
 */
public class ReverseBits {

	private static int swapBits(int n, int i, int j) {
		int maskLeft = 1 << i;
		int maskRight = 1 << j;
		
		int maskNegLeft = 1 << (i);
		maskNegLeft = ~maskNegLeft;
		
		int maskNegRight = 1 << (j);
		maskNegRight = ~maskNegRight;		
		
		int left = n & maskLeft;
		int right = n & maskRight;
						
		if (left == 0 && right>=1) {
			n = n | maskLeft;
			n = n & maskNegRight;		
		} else if (left >= 1 && right==0) {
			n = n & maskNegLeft;
			n = n | maskRight;
		}
		
		return n;
	}
	
	
	
	public static int reverseBits(int n) {

		int temp = n;
		int len = 0;
		while (temp > 0) {
			temp = temp >> 1;
			len++;
		}

		for (int i=0; i<len/2; i++) {
			n = swapBits(n, len-i-1, i);
		}
		
		return n;
	}

	public static void main(String[] args) {
		int n = 43261596;
		System.out.println("Reversing("+n+"): '"+Integer.toBinaryString(n)+"'");
		int result = reverseBits(43261596);
		System.out.println("Result("+result+"): '"+Integer.toBinaryString(result)+"'");

	}

}
