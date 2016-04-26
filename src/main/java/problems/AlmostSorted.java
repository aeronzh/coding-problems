package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Given an array with n elements, can you sort this array in ascending order
 * using only one of the following operations?
 * 
 * Swap two elements.
 * 
 * Reverse one sub-segment.
 * 
 * 
 * Input Format
 * 
 * The first line contains a single integer, n, which indicates the size of the
 * array.
 * 
 * The next line contains nn integers separated by spaces.
 * 
 * n 
 * 
 * d1 d2 ... dn
 * 
 * Constraints
 * 
 * 2≤n≤100000
 * 
 * 0≤d
 * 
 * di ≤ 1000000
 * 
 * All di are distinct.
 * 
 * Output Format
 * 
 * 1. If the array is already sorted, output yes on the first line. You do not
 * need to output anything else.
 * 
 * If you can sort this array using one single operation (from the two permitted
 * operations) then output yes on the first line and then:
 * 
 * a. If you can sort the array by swapping dl and dr, output swap l r in the
 * second line. l and r are the indices of the elements to be swapped, assuming
 * that the array is indexed from 1 to n.
 * 
 * b. Else if it is possible to sort the array by reversing the segment
 * d[l...r]d[l...r], output reverse l r in the second line. l and r are the
 * indices of the first and last elements of the subsequence to be reversed,
 * assuming that the array is indexed from 1 to n.
 * 
 * d[l...r]d[l...r] represents the sub-sequence of the array, beginning at index
 * l and ending at index r, both inclusive.
 * 
 * If an array can be sorted by either swapping or reversing, stick to the
 * swap-based method.
 * 
 * If you cannot sort the array in either of the above ways, output no in the
 * first line.
 * 
 * @author lucas
 *
 */
public class AlmostSorted {
	
	// 6
	// 1 5 4 3 2 6
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner outputScanner = new Scanner(new FileInputStream(System.getProperty("user.home") + "/" + "out.txt"));

		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		int[] num = new int[n];

		int smallerCount = 0;
		int right=0;
		int left=-1;
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(scanner.next());
			num[i] = x;
			
			if (i>0 && num[i]<num[i-1]) {
				smallerCount++;
				right = i;
				if (left == -1) {
					left = i-1;
				}
			}
		}
		
		if (left == -1) {
			System.out.println("yes");
			return;
		}


		// check reverse
		int diff = (right-left);
		boolean reverse = false;
		if (smallerCount == diff) {
			reverse = true;
			if (right<n-1 && num[left]>num[right+1]) {
				reverse = false;
			}
			
			if (left>0 && num[right]<num[left-1]) {
				reverse = false;
			}
		}
		
		boolean swap = false;
		if (smallerCount <= 2) {
			swap = true;
			if (right<n-1 && num[left]>num[right+1]) {
				swap = false;
			}
			
			if (left>0 && num[right]<num[left-1]) {
				swap = false;
			}
		}
				
		if (swap==true) {
			System.out.println("yes");
			System.out.println("swap "+(left+1)+" "+(right+1));
		} else if (reverse == true) {
			System.out.println("yes");
			System.out.println("reverse "+(left+1)+" "+(right+1));
		} else {
			System.out.println("no");
		}
	}

}
