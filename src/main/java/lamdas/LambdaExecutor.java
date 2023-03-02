package lamdas;

public class LambdaExecutor {

    public static void execute() {
        Printable printable = fileName -> "Printing file named: " + fileName;
        printThing(printable);
        GenericFunctionalInterface<String> reverseString =
                str -> {
                    StringBuilder result = new StringBuilder();
                    for (int i = str.length() - 1; i >= 0; i--) {
                        result.append(str.charAt(i));
                    }
                    return result.toString();
                };
        GenericFunctionalInterface<Integer> squareNumber =
                number -> number * number;
        System.out.println(reverseString.process("Water"));
        System.out.println(squareNumber.process(5));
    }

    static void printThing(Printable printable) {
        System.out.println(printable.print("Geography"));
    }
}
