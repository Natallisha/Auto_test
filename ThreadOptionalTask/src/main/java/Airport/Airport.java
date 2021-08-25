package Airport;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Airport<T> {

    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> queue = new LinkedList<>();

    public Airport(Queue<T> sources) {
        queue.addAll(sources);
    }

    public T getLine() {
        T line;
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        line = queue.poll();
        return line;
    }

    public void returnResources(T res) {
        queue.add(res);
        semaphore.release();
    }
}

