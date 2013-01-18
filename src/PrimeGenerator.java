public class PrimeGenerator {
	private int[] primeNumbers;
	private int primeNumCount;
	private int maxPrimNum;

	public PrimeGenerator() {
		this.primeNumbers = new int[256];
		int[] trivealPrimeNumbers = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97 };
		this.primeNumCount = trivealPrimeNumbers.length;
		System.arraycopy(trivealPrimeNumbers, 0, this.primeNumbers, 0, this.primeNumCount);
		this.maxPrimNum = trivealPrimeNumbers[trivealPrimeNumbers.length - 1];
	}

	private void extendArray(int n) {
		int[] newArray = new int[this.primeNumbers.length + n];
		System.arraycopy(this.primeNumbers, 0, newArray, 0, this.primeNumbers.length);
		this.primeNumbers = newArray;
	}

	private void addPrimeNum(int primeNum) {
		try {
			this.primeNumbers[this.primeNumCount] = primeNum;
			this.primeNumCount++;
			this.maxPrimNum = primeNum;
		} catch (IndexOutOfBoundsException e) {
			extendArray(128);
			this.primeNumbers[this.primeNumCount] = primeNum;
			this.primeNumCount++;
			this.maxPrimNum = primeNum;
		}
	}

	private int sqrt(int n) {
		return (int) Math.floor(Math.sqrt((double) n));
	}

	private class NotPrimeException extends Exception {
		private static final long serialVersionUID = 8308469685059472073L;

		public NotPrimeException() {
			super();
		}
	}

	private void preparePrimeNumbers(int max) {
		if (max > this.maxPrimNum) {
			int maxSqrt = this.sqrt(max);
			if (maxSqrt > this.maxPrimNum) {
				this.preparePrimeNumbers(maxSqrt);
			}

			for (int k = this.maxPrimNum + 1; k <= max; k++) {
				try {
					int sqrt = this.sqrt(k);
					for (int i = 0; i < this.primeNumCount && this.primeNumbers[i] <= sqrt; i++) {
						if (k % this.primeNumbers[i] == 0) {
							throw new NotPrimeException();
						}
					}
					addPrimeNum(k);
				} catch (NotPrimeException e) {
					;
				}
			}
		}
	}

	public int k;

	private void printPrimeNumbers(int min, int max) {
		// int found = 0;
		int maxSqrt = this.sqrt(max);

		this.preparePrimeNumbers(maxSqrt);

		for (k = min; k <= max; k++) {
			if (k == 100493) {
				System.out.println("Look out!!!");
			}
			try {
				int sqrt = this.sqrt(k);
				for (int i = 0; i < this.primeNumCount && this.primeNumbers[i] <= sqrt; i++) {
					if (k % this.primeNumbers[i] == 0) {
						throw new NotPrimeException();
					}
				}
				System.out.println(k);
				// found++;
			} catch (NotPrimeException e) {
				;
			}
		}
	}

	public static void main(String[] args) {
		PrimeGenerator p = new PrimeGenerator();
		try {
			p.printPrimeNumbers(999900000, 1000000000);
		} catch (RuntimeException e) {
			System.err.println("Crashed at number: " + p.k);
			throw e;
		}
	}

}
