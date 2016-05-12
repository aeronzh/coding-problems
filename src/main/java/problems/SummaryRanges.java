package problems;


/**
 * Given a sorted integer array without duplicates, return the summary of its
 * ranges for consecutive numbers.
 * 
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author lucas
 *
 */
public class SummaryRanges {

	public static void solve(int[] a) {
		int i = 1;
		int start = a[0];
		while (i<a.length) {
			if (a[i]==a[i-1]+1) {
			} else {
				System.out.println(start +"->"+a[i-1]);
				start = a[i];
			}
			i++;
		}
		
		System.out.println(start +"->"+a[a.length-1]);

	}
	
	public static void main(String[] args) {
		int[] array = new int[]{0,1,2,4,5,7};
		solve(array);
	}

}
