package problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a stream of integers, all of which come in pairs except for one, find the integer without a duplicate.  
 * 
 * @author lucas
 *
 */
public class PairStream {

	// O(n) runtime, O(1) space
	private static int findSoloXor(int[] array) {
		int result = array[0];
		
		for (int i=1; i<array.length; i++) {
			result ^=array[i];
		}


		return result;
	}
	
	// O(n) runtime, O(n) space
	private static int findSolo(int[] array) {
		Map<Integer, Integer> number2count = new HashMap<Integer, Integer>();
		
		for (int number:array) {
			if (!number2count.containsKey(number)) {
				number2count.put(number, 0);
			} else {
				int count = number2count.get(number);
				number2count.put(number, count+1);
			}
		}
		
		for (Integer key:number2count.keySet()) {
			int count = number2count.get(key);
			if (count<2) {
				return key;
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(findSoloXor(new int[]{1,2,3,3,2,1,19,5,7,5,7}));
	}

}
