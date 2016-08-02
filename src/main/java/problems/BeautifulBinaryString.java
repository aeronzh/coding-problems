package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Alice has a binary string, B , of length n. She thinks a binary string is
 * beautiful if and only if it doesn't contain the substring "010".
 * 
 * In one step, Alice can change a 0 to a 1 (or vice-versa). Count and print the
 * minimum number of steps needed to make Alice see the string as beautiful.
 * 
 * Input Format
 * 
 * The first line contains an integer, (the length of binary string B). The
 * second line contains a single binary string, B, of length n.
 * 
 * @author lucas
 *
 */
public class BeautifulBinaryString {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		String s = in.next();
		
		Pattern p = Pattern.compile("010");
	    Matcher m = p.matcher(s);
	    int count = 0;
	    while (m.find()){
	    	count +=1;
	    }
	    System.out.println(count);
	}
}
