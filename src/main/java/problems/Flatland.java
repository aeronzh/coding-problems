package problems;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Flatland is a country with n cities, m of which have space stations. Its cities (c) are numbered from 0 to n-1 , where ith city is referred to as c_i.
 * <p>
 * Between each c_i and c_(i+1) (where 0<= i < n), there exists a bidirectional road 1km long.
 * <p>
 * For example, if n=5 and cities c_0 and c_4 have space stations, Flatland would look like this:
 * <p>
 * (0) ----- 1 ----- 2 ----- 3 ----- (4)
 * <p>
 * For each city, determine its distance to the nearest space station and print the maximum of these distances.
 * <p>
 * Input Format
 * <p>
 * The first line consists of two space-separated integers, n and m.
 * The second line contains m space-separated integers c_0,c_1,....c_(m-1) denoting the index of each city having a space station. These values are unordered and unique.
 * <p>
 * Output Format
 * <p>
 * Print an integer denoting the maximum distance that an astronaut in a Flatland city would need to travel to reach the nearest space station.
 */
public class Flatland {

    private static void solve(int[] c, int n, int m) {
        int[] dist = new int[n]; // dist[i] holds the distance to the nearest space station for city i

        Arrays.sort(c);

        int prevStationIndex = 0;
        for (int i = 0; i < c.length; i++) {
            int currentStation = c[i];
            int left = Math.max(0, currentStation - (currentStation - prevStationIndex) / 2);
            if (i == 0) {
                left = 0;
            }
            prevStationIndex = currentStation;

            int right = n - 1;
            if (i < c.length - 1) {
                int nextStation = c[i + 1];
                right = Math.min(n - 1, currentStation + (nextStation - currentStation) / 2);
            }

            dist[currentStation] = 0;
            // Update left cities
            for (int l = currentStation - 1; l >= left; l--) {
                dist[l] = dist[l + 1] + 1;
            }


            // Update right cities
            for (int r = currentStation + 1; r <= right; r++) {
                dist[r] = dist[r - 1] + 1;
            }
        }

        int max = dist[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dist[i]);
        }

        System.out.println(max);
    }

    public static void main(String[] args) throws FileNotFoundException {
        System.setIn(new FileInputStream(System.getProperty("user.home") + "/" + "in.txt"));
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();
        int[] c = new int[m]; // indices of cities with space station

        for (int i = 0; i < m; i++) {
            c[i] = in.nextInt();
        }

        solve(c, n, m);

    }
}
