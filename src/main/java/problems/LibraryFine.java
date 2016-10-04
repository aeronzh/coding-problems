package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class LibraryFine {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);
        // Actual Return
        int d1 = in.nextInt();
        int m1 = in.nextInt();
        int y1 = in.nextInt();
        
        // Expected Return
        int d2 = in.nextInt();
        int m2 = in.nextInt();
        int y2 = in.nextInt();
        
        // 1. If the book is returned on or before the expected return date, no fine will be charged (i.e.: fine = 0)
        if (y1<y2 || (y1==y2 && m1<m2) || (y1==y2 && m1==m2 && d1<=d2)) {
        	System.out.println(0);
        	return;
        }
        
        // 2. If the book is returned after the expected return day but still within the same calendar month and year as the expected return date,
        // fine = 15 Hackos * (the number of days later)
        if (y1==y2 && m1==m2 && d1>d2) {
        	System.out.println((d1-d2)*15);
        	return;
        }
        
        // 3. If the book is returned after the expected return month but still within the same calendar year as the expected return date, the
        // fine = 500 Hackos * (the number of months later)
        if (y1==y2 && m1>m2) {
        	System.out.println((m1-m2)*500);
        	return;
        }
        
        //4. If the book is returned after the calendar year in which it was expected, there is a fixed fine of 10000 Hackos
        if (y1>y2) {
        	System.out.println(10000);
        	return;
        }
    }

}
