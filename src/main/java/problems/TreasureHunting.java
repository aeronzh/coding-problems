package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Find k and n such that k(a,b) +n(a',b') = (x,y)
 * 
 * (a',b') orthogonal vector to (a,b). That is a'*a + b'*b = 0
 * 
 * a'a = -b'b a' = -b'b/a
 *
 * b' = -a'a/b
 * 
 * http://programminginvisualcpp.blogspot.de/2014/10/write-java-program-that-uses-cramers.html
 * 
 * @author lucas
 *
 */
public class TreasureHunting {

	/**
	 * ak + pn = x
	 * bk + qn = y
	 * 
	 * We are looking for k and n
	 */
	private static double[] cramersRule(long a, long b, long p, long q, long x, long y) {
		double den=(a*q)-(p*b); 
		
		double k= ((x*q)-(p*y))/den;  
	    double n= ((a*y)-(x*b))/den;  
	    
	    return new double[]{k,n};
	}
	
	/**
	 * let p,q represent ortho vector for a,b as per given discussion.
	 * 
	 * Then a.p + b.q = 0 => p = (-b.q)/a also p.p + q.q = a.a + b.b =>
	 * (-b.q)*(-b.q)/(a.a) + q.q = a.a + b.b => (b.b)(q.q) + (a.a)(q.q) = (a.a +
	 * b.b).(a.a) => (a.a + b.b).(q.q) = (a.a + b.b).(a.a) => q.q = a.a =>
	 * 
	 * q = +a or -a
	 * 
	 * if q = +a then p = (-b.(+a))/a => p = -b
	 * 
	 * if q = -a then p = (-b.(-a))/a => p =b
	 * 
	 * so values set for p,q is (a,-b) or (-a,b)
	 * 
	 * both should work.
	 * 
	 * @param x
	 * @param y
	 * @param a
	 * @param b
	 */
	private static void solve(long x, long y, long a, long b) {
		long q, p;

		//q = +a or -a

		p = -1 * b;
		q = a;
		double[] kn = cramersRule(a, b, p, q, x, y);
		System.out.printf("%.12f" , kn[0]);
		System.out.println();
		System.out.printf("%.12f" , kn[1]);
		
		
//		q = -1 * a;
//		p = b;
//		kn = cramersRule(a, b, p, q, x, y);
//		System.out.println();
//		System.out.println(kn[0]+"  "+kn[1]);

	}

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);

		long x = in.nextLong();
		long y = in.nextLong();
		long a = in.nextLong();
		long b = in.nextLong();
		
		solve(x, y, a, b);
	}

}
