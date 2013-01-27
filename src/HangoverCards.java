public class HangoverCards {

	private static int binSearch(int[] r, int x) {
		int a = 0;
		int b = r.length - 1;
		while (a < b - 1) {
			int i = (a + b) / 2;
			double y = r[i];
			if (y == x) return i;
			if (y > x) b = i;
			else a = i;
		}
		return r[a] >= x ? a : b;
	}

	public static void main(String[] args) {
		int[] r = new int[277];
		r[0] = 500000;
		for (int i = 1; i < 277; i++) {
			r[i] = r[i - 1] + 1000000 / (i + 2);
		}

		java.util.Scanner in = new java.util.Scanner(System.in);
		try {
			double x;
			while ((x = in.nextDouble()) != 0) {
				System.out.println((binSearch(r, (int) (1000000 * x)) + 1) + " card(s)");
			}
		} finally {
			in.close();
		}
	}
}
