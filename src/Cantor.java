public class Cantor {
	public static String nthFraction(int n) {
		int row = (int) Math.ceil((Math.sqrt(8 * n + 1) - 1) / 2);
		int pos = n - (row * (row - 1)) / 2;
		int a, b;
		if ((row & 1) == 0) { a = pos; b = row - pos + 1; }
		else { a = row - pos + 1; b = pos; }
		return (new StringBuilder()).append("TERM ").append(n).append(" IS ").append(a).append('/').append(b).toString();
	}

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		try {
			for (int i=0, t = in.nextInt(); i<t; i++) {
				System.out.println(nthFraction(in.nextInt()));
			}
		} finally {
			in.close();
		}
	}

}
