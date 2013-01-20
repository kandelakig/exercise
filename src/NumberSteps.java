public class NumberSteps {
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		try {
			for (int i = 0, n = in.nextInt(); i < n; i++) {
				int x = in.nextInt(), y = in.nextInt();
				System.out.println((x == y || x == y + 2) ? (x - y + (4 * (y >> 1) + (y & 1))) : "No Number");
			}
		} finally {
			in.close();
		}
	}
}
