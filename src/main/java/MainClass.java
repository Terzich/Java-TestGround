import fork_join_framework.CustomRecursiveAction;
import fork_join_framework.CustomRecursiveTask;
import fork_join_framework.Fibonacci;
import lamdas.LambdaExecutor;
import optionals.OptionalExecutor;
import stream_api.StreamApiExecutor;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class MainClass {

    public static void main(String[] args) {

        // -----> LAMBDA EXPRESSIONS <-----
        LambdaExecutor lambdaExecutor = new LambdaExecutor();
        lambdaExecutor.execute();

        // -----> JAVA STREAM API <-----
        StreamApiExecutor streamApiExecutor = new StreamApiExecutor();
        streamApiExecutor.execute();

        // -----> JAVA OPTIONALS <-----
        OptionalExecutor optionalExecutor = new OptionalExecutor();
        optionalExecutor.execute();

        // -----> FORK / JOIN FRAMEWORK <-----
        ForkJoinPool commonPool = ForkJoinPool.commonPool();
        CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("elephant,cat,dog,fish,cheetah,bear,giraffe,bird,dolphin");
        commonPool.execute(customRecursiveAction);
        customRecursiveAction.join();
        customRecursiveAction.compute();
        int[] arr = {2,4,15,8,11};
        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(arr);
        System.out.println(customRecursiveTask.compute());
        Fibonacci fibonacci = new Fibonacci(10);
        System.out.println(fibonacci.compute());
    }
}
