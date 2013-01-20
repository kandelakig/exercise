import java.util.Date;

public class InheritanceFail extends Super {
	private final Date date; // Blank final, set by constructor

	InheritanceFail() {
		date = new Date();
	}

	// Overriding method invoked by superclass constructor
	@Override
	public void overrideMe() {
		System.out.println(date.toString());
	}

	public static void main(String[] args) {
		InheritanceFail sub = new InheritanceFail();
		sub.overrideMe();
	}
}

class Super {
	// Broken - constructor invokes an overridable method
	public Super() {
		overrideMe();
	}

	public void overrideMe() {
	}
}