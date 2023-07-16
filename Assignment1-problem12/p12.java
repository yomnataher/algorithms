import java.util.Arrays;
import java.util.Comparator;

public class CloestPairOfPoints {

	public static void main(String[] args) {

		Point[] points = new Point[6];

		points[0] = new Point(2, 3);
		points[1] = new Point(12, 30);
		points[2] = new Point(40, 50);
		points[3] = new Point(5, 1);
		points[4] = new Point(12, 10);
		points[5] = new Point(3, 4);

		double minDist = closest(points);
		System.out.println(minDist);
		double minDistBruteForce = bruteForce(points);
		System.out.println(minDistBruteForce);

	}
	private static double dist(Point p1, Point p2) {
		return Math.sqrt((p1.x - p2.x) * (p1.x - p2.x) + (p1.y - p2.y)* (p1.y - p2.y));
	}

	public static double bruteForce(Point[] P) {
		double min = Double.MAX_VALUE;
		int n = P.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				min = Math.min(min, dist(P[i], P[j]));
			}
		}
		return min;
	}

	public static double closest(Point[] P) {
		System.out.println("Before soring:");
		System.out.println(Arrays.toString(P));
		Arrays.sort(P, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.x - p2.x;
			}
		});
		System.out.println("After sorting in x axis:");
		System.out.println(Arrays.toString(P));

		return closestUtil(P, 0, P.length - 1);
	}

	private static double closestUtil(Point[] P, int begin, int end) {
		int n = end - begin + 1;
		if (n <= 3) 
		{	
			return bruteForce(P);
		}

		int mid = n/2;		
		Point midPoint = P[mid];

		double left = closestUtil(P, begin, mid);
		double right = closestUtil(P, mid, end);

	
		double distMin = Math.min(left, right);
		Point[] strip = new Point[n];
		int stripLen = 0;

		for (int i = 0; i < n; i++) {
			if (Math.abs(P[i].x - midPoint.x) < distMin) {
				strip[stripLen] = P[i];
				stripLen++;
			}
		}
		return Math.min(distMin, stripCloest(strip, stripLen, distMin));
	}
	private static double stripCloest(Point[] strip, int stripLen,
			double distMin) {
		
		Arrays.sort(strip, 0, stripLen, new Comparator<Point>() {
			@Override
			public int compare(Point p1, Point p2) {
				return p1.y - p2.y;
			}
		});

		System.out.println("After sorting in y axis for strip:");
		System.out.println(Arrays.toString(strip));
		double min = distMin;
		for (int i=0; i<stripLen; i++) {
			for(int j=i+1; j<stripLen && (strip[j].y - strip[i].y < min); j++) {
				min = Math.min(min, dist(strip[i], strip[j]));
			}
		}
		
		return min;
	}

	
	static class Point {
		int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "[x=" + x + ", y=" + y + "]";
		}
	}

}