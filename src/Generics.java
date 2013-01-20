import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class Generics {

	@SafeVarargs
	public static <T> T[] array(T... args) {
		return args;
	}

	public static <T extends Collection<E>, E extends Number> int countOdds(T list) {
		int count = 0;
		for (E elem : list) {
			count += elem.longValue() % 2;
		}
		return count;
	}

	public static <T> T[] swapElements(T[] arr, int i, int j) {
		T[] copy = Arrays.copyOf(arr, arr.length);
		copy[i] = arr[j];
		copy[j] = arr[i];
		return copy;
	}

	private static <T extends Comparable<T>> void checkInput(T[] arr, int start, int end) throws IllegalArgumentException {
		if (start >= end)
			throw new IllegalArgumentException("`start` must be less then `end`");
		if (start < 0)
			throw new IllegalArgumentException("`start` cannot be negative");
		if (end >= arr.length)
			throw new IllegalArgumentException("`end` is out of bonds");
	}

	public static <T extends Comparable<T>> T maxInRange(T[] arr, int start, int end) {
		checkInput(arr, start, end);
		T max = arr[start];
		for (int i = start + 1; i <= end; i++) {
			max = max.compareTo(arr[i]) < 0 ? arr[i] : max;
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(countOdds(Arrays.asList(3, 3, 5, 6, 8, 10.4)));
		System.out.println(Arrays.toString(swapElements(array(3, 5, 7, 9), 2, 3)));
		System.out.println(maxInRange(array(3, 4, 5, 600, 2, 3), 0, 2));
	}

}
