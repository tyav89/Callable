import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {
    private String name;
    private int time;

    public MyCallable(String name, int time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    @Override
    public Integer call() throws Exception {
        for (int i = 0; i < time; i++) {
            Thread.sleep(3000);
            System.out.printf("Я поток %s. Всем привет!\n", this.getName());
        }
        return time;
    }
}
