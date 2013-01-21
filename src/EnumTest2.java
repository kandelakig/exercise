interface Operation {
	public double apply(double x, double y);
}

// Enum type with constant-specific class bodies and data
enum BasicOperation implements Operation {
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	},
	MINUS("-") {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	},
	TIMES("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	},
	DIVIDE("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	};

	private final String symbol;

	BasicOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}

enum ExtendedOperation implements Operation {
	POWER("^") {
		@Override
		public double apply(double x, double y) {
			return Math.pow(x, y);
		}
	};

	private final String symbol;

	private ExtendedOperation(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return symbol;
	}
}

public class EnumTest2 {
	private static <T extends Enum<T> & Operation> void execAllOperations(Class<T> c, double x, double y) {
		for (Operation op : c.getEnumConstants())
			System.out.printf("%f %s %f = %f%n", x, op, y, op.apply(x, y));
	}

	public static void main(String[] args) {
		execAllOperations(BasicOperation.class, 12, 3);
		execAllOperations(ExtendedOperation.class, 12, 3);
	}
}
