class Fashion {
	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		try {
			int testCases = in.nextInt();
			for (int i = 0; i < testCases; i++) {
				int couples = in.nextInt();
				int[] men = new int[couples];
				int[] women = new int[couples];
				for (int j = 0; j < couples; j++)
					men[j] = in.nextInt();
				for (int j = 0; j < couples; j++)
					women[j] = in.nextInt();
				java.util.Arrays.sort(men);
				java.util.Arrays.sort(women);
				int sum = 0;
				for (int j = 0; j < couples; j++)
					sum += men[j] * women[j];
				System.out.println(sum);
			}
		} finally {
			in.close();
		}
	}
}
