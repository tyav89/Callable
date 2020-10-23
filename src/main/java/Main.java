import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Callable<String>> listCallable = new ArrayList<>();

        listCallable.add(new MyCallable("1", 4));
        listCallable.add(new MyCallable("2", 5));
        listCallable.add(new MyCallable("3", 6));
        listCallable.add(new MyCallable("4", 7));

        ExecutorService threadPool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Future<String>> listFutureAll = threadPool.invokeAll(listCallable);
        for (Future<String> future : listFutureAll) {
            System.out.println(future.get());
        }

        //String result = threadPool.invokeAny(listCallable);
        //System.out.println(result);

        threadPool.shutdown();

    }
}
