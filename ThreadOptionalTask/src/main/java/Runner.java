import Airport.Airport;
import Airport.Line;
import Airport.Plane;

import java.util.LinkedList;

public class Runner {
    public static void main(String[] args) {
        LinkedList<Line> listOfLines = new LinkedList<>() {
            {
                this.add(new Line(1));
                this.add(new Line(2));
                this.add(new Line(3));
                this.add(new Line(4));
                this.add(new Line(5));
            }
        };
        Airport<Line> pool = new Airport<>(listOfLines);
        for (int i = 0; i < 10; i++) {
            new Plane(pool, i).start();

        }
    }
}
