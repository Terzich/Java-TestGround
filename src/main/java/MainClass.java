import lamdas.LambdaMiddleware;
import lamdas.Printable;

public class MainClass {

	public static void main(String[] args) {
		Printable printable = fileName -> "Printing file named: " + fileName;
		LambdaMiddleware.printThing(printable);
	}
}
