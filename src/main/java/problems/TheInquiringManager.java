package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class TheInquiringManager {
	private static final int ORDER = 1;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));

		Scanner in = new Scanner(System.in);

		// Read input
		int n = in.nextInt();

		Map<Long, Long> time2price = new HashMap<Long, Long>();

		for (int i = 0; i < n; i++) {
			int type = in.nextInt();
			if (type == ORDER) {
				Long price = in.nextLong();
				Long time = in.nextLong();
				if (time2price.containsKey(time)) {
					time2price.put(time, time2price.get(time) < price ? price : time2price.get(time));
				} else {
					time2price.put(time, price);
				}

				Iterator<Map.Entry<Long, Long>> iter = time2price.entrySet().iterator();
				while (iter.hasNext()) {
					Map.Entry<Long, Long> entry = iter.next();
					if (entry.getKey() < time - 60) {
						iter.remove();
					}
				}

			} else {
				Long time = in.nextLong();
				Long max = -1l;
				for (Long t : time2price.keySet()) {
					if (t > time - 60) {
						max = Math.max(time2price.get(t), max);
					}
				}

				System.out.println(max);
			}
		}

	}
}
