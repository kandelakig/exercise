public class DivSum {

	private static int[] PRIMES = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113,
			127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239, 241, 251, 257, 263, 269, 271, 277,
			281, 283, 293, 307, 311, 313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383, 389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
			461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541, 547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613, 617, 619, 631, 641, 643,
			647, 653, 659, 661, 673, 677, 683, 691, 701 };

	public static int calc1(int n) {
		int sqrt = (int) Math.sqrt(n);
		int sum = 1;
		for (int i = 2; i <= sqrt; i++) {
			if (n % i == 0)	sum += i + n / i;
		}
		return sum;
	}

	public static int calc2(int n) {
		int sqrt = (int) Math.sqrt(n);
		boolean[] ints = new boolean[sqrt + 1];
		for (int i = 2; i <= sqrt; i++) { ints[i] = true; }
		int sum = 1;
		for (int i = 2; i <= sqrt; i++) {
			if (ints[i]) {
				if (n % i == 0)	sum += i + n / i;
				else for (int j = 2, m = sqrt / i; j <= m; j++) { ints[i * j] = false; }
			}
		}
		return sum;
	}

	private static int[] primeFactors(int n) {
		final int primeCount = PRIMES.length;
		int[] result = new int[primeCount];
		for (int i = 0; i < primeCount && PRIMES[i] <= (n >> 1); i++) {
			int p = PRIMES[i];
			result[i] = 0;
			for (int x = n; x % p == 0; x /= p) {
				result[i]++;
			}
		}
		return result;
	}

	public static int calc3(int n) {
		int[] primeFactors = primeFactors(n);
		int result = 1;
		for (int i = 0, k = primeFactors.length; i < k && PRIMES[i] <= (n >> 1); i++) {
			if (primeFactors[i] > 0) {
				result *= (Math.pow(PRIMES[i], primeFactors[i] + 1) - 1) / (PRIMES[i] - 1);
			}
		}
		return result == 1 ? 1 : result - n;
	}
	
	private static java.util.Map<Integer, Integer> results = new java.util.HashMap<Integer, Integer>();

	public static void main(String[] args) {
		java.util.Scanner in = new java.util.Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		try {
			for (int i = 0, n = in.nextInt(); i < n; i++) {
				int x = in.nextInt();
				if (!results.containsKey(x)) results.put(x, calc3(x));
				sb.append(results.get(x)).append('\n');
			}
		} finally {
			in.close();
		}
		System.out.println(sb.toString());
	}
}