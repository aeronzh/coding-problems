package problems;

import java.util.Arrays;

public class SmallestTimeDifference {
    private static int solve(String[] times) {
        int[] timeInMinutes = new int[times.length];

        // Convert each time to minutes
        for (int i = 0; i < times.length; i++) {
            timeInMinutes[i] = Integer.valueOf(times[i].split(":")[0]) * 60 + Integer.valueOf(times[i].split(":")[1]);
        }

        // Sort
        Arrays.sort(timeInMinutes);

        // Iterate over times and subtract each time from the following one
        int diff = Integer.MAX_VALUE;
        for (int i=0; i<timeInMinutes.length-1; i++) {
            diff = Math.min(diff, timeInMinutes[i+1] - timeInMinutes[i]);
        }

        // Circle : add 1440 (24 hour) to the first and subtract the last from it. That is make the first
        // time the following time of the last to complete the circle.
        diff = Math.min(diff, (timeInMinutes[0] + 1440) - timeInMinutes[timeInMinutes.length-1]);

        return diff;
    }

    public static void main(String args[]) {
        //String times[] = {"2:30", "00:00", "00:12", "24:00", "23:55"};
        // String times[] = {"2:30", "00:12", "3:00"};
        String times[] = {"23:20","23:30","23:36","23:55","01:00"};
        // 1400 1410 1416 1435 0
        // 60 1400 1410 1416 1435
        System.out.println(solve(times));
    }
}

