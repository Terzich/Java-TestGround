import lamdas.LambdaExecutor;
import optionals.OptionalExecutor;
import stream_api.StreamApiExecutor;

public class MainClass {

    public static void main(String[] args) {

        // -----> LAMBDA EXPRESSIONS <-----
        LambdaExecutor.execute();

        // -----> JAVA STREAM API <-----
        StreamApiExecutor.execute();

        // -----> JAVA OPTIONALS <-----
        OptionalExecutor.execute();
    }
}
