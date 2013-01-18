import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dummy {

	@SafeVarargs
	public static <T> T[] array(T... args) {
		return args;
	}
	
	private static void printList1(List<?> list) {
		System.out.println("printList1:");
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
	private static <T> void printList2(List<T> list) {
		System.out.println("printList2:");
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}

	public static void main(String[] args) {
		for (int i : array(1, 2, 3, 4))
			System.out.println(i);
		for (Object s : array("Hello", "World", 1))
			System.out.println(s);
		
		printList1(Arrays.asList(1, 2, 3));
		printList2(Arrays.asList(1, 2, 3));
		
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(4);
		intList.add(5);
		intList.add(6);
		printList1(intList);
		printList2(intList);
		
		Object[] objArr = new String[2];
		objArr[0] = "alila";
//		objArr[1] = 5;  -->  java.lang.ArrayStoreException
	}

}
