package problems;

/**
 * There are N gas stations along a circular route, where the amount of gas at
 * station i is gas[i].
 * 
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to
 * travel from station i to its next station (i+1). You begin the journey with
 * an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit
 * once, otherwise return -1.
 * 
 * @author lucas
 *
 */
public class GasStation {
	private static int[] gas = { 5, 3, 10, 11, 2, 7 };
	private static int[] cost = { 6, 4, 10, 1, 1, 9 };

	private static int returnIndex() {
		int result = -1;

		int len = gas.length;
		int totalRemaining = 0;
		for (int i = 0; i < len; i++) {
			int remaining = gas[i] - cost[i];

			if (totalRemaining >= 0) {
				totalRemaining += remaining;
			} else {
				totalRemaining = remaining;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(returnIndex());

	}

}
