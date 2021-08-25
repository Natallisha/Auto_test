package Airport;

import java.util.concurrent.TimeUnit;

public class Plane extends Thread {

    private boolean planeOnTheLine = false;
    private final Airport<Line> pool;
    private final int id;
    private Line line;


    private static final int TIME_FOR_TAKE_OFF = 3;

    public Plane(Airport pool, int id) {
        this.pool = pool;
        this.id = id;
    }

    public void run() {
        try {
            line = pool.getLine();
            planeOnTheLine = true;
            usingLine();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (line != null) {
                System.out.println("The line " + line.getLineId() + " get the plane " + this.getId());
                planeOnTheLine = false;
                System.out.println("The line " + line.getLineId() + " is empty");
                pool.returnResources(line);
            }
        }
    }

    public void usingLine() {
        try {
            System.out.println("The plane " + this.getId() + " started exit to the line " + line.getLineId());
            TimeUnit.SECONDS.sleep(TIME_FOR_TAKE_OFF);
            System.out.println("The plane " + this.getId() + " is in the sky");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public long getId() {
        return id;
    }
}
