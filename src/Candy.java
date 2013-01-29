public class Candy {
	public static int countMoves(int[] bags) {
		int sum = 0;
		for (int b : bags) { sum += b; }
		int avg;
		if (sum % bags.length != 0) return -1;
		else avg = sum / bags.length;
		int moves = 0;
		for (int b : bags) { if (b < avg) moves += avg - b; }
		return moves;
	}
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		try {
			for (int n = in.nextInt(); n > -1; n = in.nextInt()) {
				int[] bags = new int[n];
				for (int i = 0; i < n; i++) { bags[i] = in.nextInt(); }
				System.out.println(countMoves(bags));
			}
		} finally { in.close(); }
	}
}