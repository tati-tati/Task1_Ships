//import java.util.Map;
//import java.util.Stack;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Channel {
    private static final int MAX_CAPACITY = 5;
    private Semaphore semaphore = new Semaphore(MAX_CAPACITY, true);
    private final List<Ship> list = new ArrayList<>(MAX_CAPACITY);

    public void shipIsArriving(Ship ship){
        try {
            semaphore.acquire();
            synchronized (list){
                if (list.size() < MAX_CAPACITY){
                    list.add(ship);
                    System.out.println( list.size() + " " + ship.toString() + " was added");
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Ship shipIsLeaving(Ship.Type type) {
        Ship ship = null;
        if (list.size() > 0) {
            Ship[] ships = list.toArray(new Ship[]{});
            for (int i = 0; i < ships.length; i++) {
                if (ships[i].getType() == type) {
                    ship = ships[i];
                    i = ships.length;
                }
            }
        }
        if (ship != null) {
            list.remove(ship);
            System.out.println( list.size() + " " + ship.toString() + " was deleted");
            semaphore.release();
//            System.out.println( list.size() + " current queue size");
        }
        return ship;
    }

}
