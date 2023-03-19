package fork_join_framework;

import java.util.concurrent.RecursiveTask;
import java.util.logging.Logger;

public class Fibonacci extends RecursiveTask<Integer> {

    private static Logger logger = Logger.getAnonymousLogger();
    private final int n;

    public Fibonacci(int n) {
        this.n = n;
    }

    @Override
    public Integer compute() {
        logger.info("This result - ('" + n + "') - was processed by " +
                Thread.currentThread().getName());
        if (n <= 1)
            return n;
        Fibonacci f1 = new Fibonacci(n - 1);
        f1.fork();
        Fibonacci f2 = new Fibonacci(n - 2);
        f2.fork();
        return f2.join() + f1.join();
    }
}
