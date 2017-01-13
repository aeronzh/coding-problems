package problems;

import java.util.Arrays;

public class RandomShuffle {
	static double count = 0;
	static double total = 0;

	private static void brute(int[] current, int[] outputArr, int index) {
		if (index == current.length) {
			total++;
			
			boolean eq = true;
			for (int i = 0; i < outputArr.length; i++) {
				if (current[i] != outputArr[i]) {
					eq = false;
				}
			}
			if (eq) {
				count++;
			}
			
			return;
		}

		for (int j = 0; j < current.length; j++) {
			//System.out.println("swap "+index+" with "+j);
			// swap
			int tmp = current[index];
			current[index] = current[j];
			current[j] = tmp;

			brute(current, outputArr, index + 1);

			// swap back
			tmp = current[index];
			current[index] = current[j];
			current[j] = tmp;
		}
	}

	public static void main(String[] args) {
		// 1 2 3 4 5
		int[] outputArr = {4,2,5,1,3};
		int[] current = Arrays.copyOf(outputArr, outputArr.length);
		Arrays.sort(current);
		brute(current, outputArr, 0);
		// 0.006720000000000001
		System.out.println(count / total);
			
		count = 0;
		total = 0;
		outputArr = new int[]{1,2};
		current = Arrays.copyOf(outputArr, outputArr.length);
		Arrays.sort(current);
		brute(current, outputArr, 0);
		// 0.5
		System.out.println(count / total);
		
		count = 0;
		total = 0;
		outputArr = new int[]{1};
		current = Arrays.copyOf(outputArr, outputArr.length);
		Arrays.sort(current);
		brute(current, outputArr, 0);
		// 1
		System.out.println(count / total);
		
		count = 0;
		total = 0;
		outputArr = new int[]{1,3,2};
		current = Arrays.copyOf(outputArr, outputArr.length);
		Arrays.sort(current);
		brute(current, outputArr, 0);
		// 0.1851851851851852
		System.out.println(count / total);
		
		count = 0;
		total = 0;
		outputArr = new int[]{4,6,9,3,5,8,10,1,7,2};
		current = Arrays.copyOf(outputArr, outputArr.length);
		Arrays.sort(current);
		brute(current, outputArr, 0);
		// 2.825E-7
		System.out.println(count / total);
	}

}
