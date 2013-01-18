class MiserMan {
	private static int N;
	private static int M;
	private static int[][] K;

	private static int smallest(int x, int y) {
		return x < y ? x : y;
	}

	private static int smallest(int x, int y, int z) {
		return smallest(x, smallest(y, z));
	}

	private static int sumFirstColumn() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += K[i][0];
		}
		return sum;
	}

	private static int minLastRow() {
		int currMin = Integer.MAX_VALUE;
		for (int i = 0; i < M; i++) {
			currMin = smallest(currMin, K[N - 1][i]);
		}
		return currMin;
	}

	private static int minAmount() {
		if (M == 1)
			return sumFirstColumn();

		for (int n = 1; n < N; n++) {
			for (int m = 0; m < M; m++) {
				if (m == 0)
					K[n][m] += smallest(K[n - 1][m], K[n - 1][m + 1]);
				else if (m == M - 1)
					K[n][m] += smallest(K[n - 1][m - 1], K[n - 1][m]);
				else
					K[n][m] += smallest(K[n - 1][m - 1], K[n - 1][m], K[n - 1][m + 1]);
			}
		}

		return minLastRow();
	}

	private static void init(java.io.InputStream inputStream) {
		java.util.Scanner in = new java.util.Scanner(inputStream);
		try {
			N = in.nextInt();
			M = in.nextInt();
			K = new int[N][M];
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					K[n][m] = in.nextInt();
				}
			}
		} finally {
			in.close();
		}
	}

	public static void main(String[] args) {
		init(System.in);
		System.out.println(minAmount());
	}

}
