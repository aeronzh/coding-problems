package problems;

// F_n = f_(n-1) + f_(n-2)
// F_0 = 0
// F_1 = 1
public class NthFibonacciNumber {

	private static int fin(int n) {
		if (n==0) {
			return 0;
		}
		
		if (n==1) {
			return 1;
		}
		
		int f0 = 0;
		int f1 = 1;
		int fn = 0;
		
		while (n>1) {
			fn = f0 + f1;
			f0 = f1;
			f1 = fn;
			n--;
		}
		
		
		return fn;
	}
	
	public static void main(String[] args) {

		System.out.println(fin(5));
		

	}

}
