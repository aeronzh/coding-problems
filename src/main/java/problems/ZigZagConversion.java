package problems;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 
 * P   I     N
 * A  L S   I G
 * Y A   H R
 * P      I
 *
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the a method convert("PAYPALISHIRING", 3) which returns "PAHNAPLSIIGYIR".
 * 
 * @author lucas
 *
 */
public class ZigZagConversion {

	public static void convert(String str, int depth) {
		char[] chars = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		int count = chars.length;
		for (int i=0; i<depth; i++) {
			int next = i;
			while (next <= chars.length - i*2 +1) {
				System.out.print(chars[next]);
				
				int offset = i*2;
				if (i>=1 && i<depth-1 && next < chars.length - offset && next>i) {
					next = next + offset;
					System.out.print(chars[next]);			
				}
				
				if (i==0 || i==depth-1) {
					next = next + 2*(depth-1);
				} else {
					next = next + 2*(depth-(i+1));
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		convert("PAYPALISHIRING", 3);

	}

}
