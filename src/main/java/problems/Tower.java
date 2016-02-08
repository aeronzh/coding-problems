package problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Image an airport with the control tower having a constantly rotating radar
 * scanning for airplanes. The radar's coordinates in the 2-d plane are (0,0).
 * The radar has an API: void scan(const Plane &P) that is called periodically
 * whenever the radar detects a plane. You can imagine that the Plane structure
 * has x,y coordinates for that plane. You should fill in the function Scan,
 * such that at any given time you are able to return the 100 closest planes to
 * the tower (0,0).
 * 
 * @author lucas
 *
 */
public class Tower {

	public static class Plane {
		private int x;
		private int y;

		public Plane(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "" + (int) distanceToTower();
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		private double distanceToTower() {
			return Math.sqrt((x - 0) * (x - 0) + (y - 0) * (y - 0));
		}
	}

	public static class Radar {
		private final int RADAR_X = 0;
		private final int RADAR_Y = 0;
		private final int BUFFER_SIZE = 10;
		private List<Plane> planes;

		public Radar() {
			planes = new ArrayList<Tower.Plane>();
		}

		public List<Plane> scan(Plane newPlane) {
			if (planes.isEmpty()) {
				planes.add(newPlane);
				return planes;
			} else {
				double newDist = distance(newPlane.getX(), newPlane.getY(), RADAR_X, RADAR_Y);
				int index = 0;
				Plane plane;
				double dist;

				do {
					plane = planes.get(index);
					dist = distance(plane.getX(), plane.getY(), RADAR_X, RADAR_Y);
					index++;
				} while (index < Math.min(BUFFER_SIZE, planes.size()) && dist <= newDist);

				if (index > 0 && index < BUFFER_SIZE) {
					planes.add(index - 1, newPlane);
				}

				return planes.subList(0, Math.min(BUFFER_SIZE, planes.size()));
			}
		}

		private double distance(int x1, int y1, int x2, int y2) {
			return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
		}
	}

	public static int random(int min, int max) {
		Random r = new Random();
		return min + r.nextInt(max - min + 1);
	}

	public static void main(String[] args) {
		List<Plane> planes = new ArrayList<Tower.Plane>();

		for (int i = 1; i <= 20; i++) {
			Plane plane = new Plane(random(1, 100), random(1, 100));
			planes.add(plane);
			System.out.print(plane + " ");
		}
		System.out.println();

		Radar radar = new Radar();
		List<Plane> result;
		for (Plane plane : planes) {
			result = radar.scan(plane);
			System.out.println(result);
		}
	}
}
