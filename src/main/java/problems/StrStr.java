package problems;

/**
 * Implement strStr().
 * 
 * Returns the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author lucas
 *
 */
public class StrStr {
	public static int strStr(String haystack, String needle) {
		if (haystack == null && needle != null) {
			return -1;
		} else {
			for (int i=0; i<haystack.length(); i++) {
				if (i+needle.length() <= haystack.length()) {
					boolean found = true;
					for (int j=0; j<needle.length(); j++) {
						if (needle.charAt(j) != haystack.charAt(i+j)) {
							found = false;
						}
					}
					
					if (found) {
						return i;
					}
				} else {
					return -1;
				}
				
			}
			
			return -1;
		}
	}
	
	public static void main(String[] args) {
		String haystack = "abcded123xyz";
		String needle = "23";
		
		System.out.println(strStr(haystack, needle));

	}

}
