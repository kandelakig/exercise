public class MiserMan {
	// private static int N = 5;
	// private static int M = 5;
	// private static int[][] K = {
	// { 1, 3, 1, 2, 6 },
	// { 10, 2, 5, 4, 15 },
	// { 10, 9, 6, 7, 1 },
	// { 2, 7, 1, 5, 3 },
	// { 8, 2, 6, 1, 9 }
	// };

	// private static int N = 5;
	// private static int M = 6;
	// private static int[][] K = {
	// { 1, 4, 6, 3, 1, 5 },
	// { 1, 5, 6, 2, 1, 1 },
	// { 1, 2, 5, 1, 51, 1 },
	// { 1, 3, 4, 6, 3, 2 },
	// { 1, 9, 3, 5, 3, 6 }
	// };

	// private static int N = 4;
	// private static int M = 3;
	// private static int[][] K = {
	// { 5, 6, 1 },
	// { 3, 5, 7 },
	// { 3, 4, 6 },
	// { 2, 4, 6 }
	// };

	private static int N = 20;
	private static int M = 20;
	private static int[][] K;
	static {
		K = new int[100][100];
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				K[i][j] = ((Double) (Math.random() * 100)).intValue();
			}
		}
	}

//	private static int N;
//	private static int M;
//	private static int[][] K;

	private static int smallest(int x, int y, int z) {
		return x < y ? x < z ? x : z : y < z ? y : z;
	}

	private static int minAmount(int n, int m) {
//		System.out.println("At possition: ["+n+"],["+m+"]");
		if (m == -1 || m > M - 1)
			return 10001;
		else if (n == N - 1)
			return K[n][m];
		else
			return K[n][m] + smallest(minAmount(n + 1, m - 1), minAmount(n + 1, m), minAmount(n + 1, m + 1));
	}

	private static void init(java.io.InputStream inputStream) {
		java.util.Scanner in = new java.util.Scanner(inputStream);
		N = in.nextInt();
		M = in.nextInt();
		K = new int[N][M];
		for (int n = 0; n < N; n++) {
			for (int m = 0; m < M; m++) {
				K[n][m] = in.nextInt();
			}
		}
	}

	public static void main(String[] args) {
//		init(System.in);

		 int currentMin = 10001;
		 for (int i = 0; i <= M; i++) {
		 int amount = minAmount(0, i);
		 currentMin = amount < currentMin ? amount : currentMin;
		 }
		 System.out.println(currentMin);
	}

}
