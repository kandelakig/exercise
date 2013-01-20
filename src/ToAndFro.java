public class ToAndFro {
	public static String decode(String msg, int columns) {
		int rows = msg.length() / columns;
		StringBuilder result = new StringBuilder();
		for (int j = 0; j < columns; j++) {
			for (int i = 0; i < rows; i++) {
				result.append((i & 1) == 0 ? msg.charAt(i * columns + j) : msg.charAt((i + 1) * columns - j - 1));
			}
		}
		return result.toString();
	}

	public static void main(String[] args) throws Exception {
		java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int columns;
		while ((columns = Integer.parseInt(in.readLine())) > 0) {
			System.out.println(decode(in.readLine(), columns));
		}
	}
}
