package Model;

import Exceptions.UnavailableParkingException;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Parking<T> {

    private final static int POOL_SIZE = 5;
    private final Semaphore semaphore = new Semaphore(POOL_SIZE, true);
    private final Queue<T> queue = new LinkedList<>();

    public Parking(Queue<T> sources) {
        queue.addAll(sources);
    }

    public T getParkingPlace(long maxWaitingTimeForParking) {
        try {
            if (semaphore.tryAcquire(maxWaitingTimeForParking, TimeUnit.SECONDS)) {
                T parkingPlace = queue.poll();
                return parkingPlace;
            }
        } catch (InterruptedException e) {
            throw new UnavailableParkingException(e);
        }
        throw new UnavailableParkingException(": out of time limit");
    }

    public void returnResources(T res) {
        queue.add(res);
        semaphore.release();
    }
}
