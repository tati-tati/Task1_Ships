//import java.util.Map;
//import java.util.Stack;
import java.util.concurrent.*;

public class Channel {
    public final int MAX_CAPACITY = 5;
//    private Stack<Thread> stack = new Stack<>();
    private LinkedBlockingQueue<Ship> queue;

    public Channel() {
        this.queue = new LinkedBlockingQueue<>(MAX_CAPACITY);
    }

//    public void openChannel(Sea sea, Map<Ship.Type, Dock> dockMap) {
//        while (stack.size() < MAX_CAPACITY) {
//            Ship ship = sea.generateRandomShip();
//            System.out.println("New Ship was added : " + ship.toString() + " for the thread : " + Thread.currentThread().getName());
//            stack.push(new Thread(() -> {
//                        Dock dock = dockMap.get(ship.getType());
//                        dock.getShip(ship);
//                        stack.removeElementAt(stack.indexOf(Thread.currentThread()));
//                        this.openChannel(sea, dockMap);
//                    })
//            ).start();
//        }
//    }

//    public int getCurrentSize(){
//        return queue.size();
//    }

//    public boolean isEmpty(){
//        return queue.isEmpty();
//    }

    public void getNewShip(Ship ship){
        if (queue.size() < MAX_CAPACITY){
            queue.add(ship);
            System.out.println("New Ship was added : " + ship.toString() + " for the thread : " + Thread.currentThread().getName());
        }
    }

    public Ship sendNewShip(Ship.Type type){
        Ship ship = null;
        Ship[] ships = queue.toArray(new Ship[]{});
        for (int i = 0; i < ships.length; i++){
            if (ships[i].getType() == type){
                ship = ships[i];
                i = ships.length;
            }
        }
        if (ship != null){
            queue.remove(ship);
        }
        return ship;
    }
}