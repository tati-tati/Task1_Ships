import java.util.Map;
import java.util.Stack;

public class Channel {
    private final int MAX_CAPACITY = 5;
    private volatile Stack<Thread> stack = new Stack<>();

    public void openChannel(Sea sea, Map<Ship.Type, Dock> dockMap) {
        while (stack.size() < MAX_CAPACITY) {
            Ship ship = sea.generateRandomShip();
            System.out.println("New Ship was added : " + ship.toString() + " for the thread : " + Thread.currentThread().getName());
            stack.push(new Thread(() -> {
                        Dock dock = dockMap.get(ship.getType());
                        dock.getShip(ship);
                        stack.removeElementAt(stack.indexOf(Thread.currentThread()));
                        this.openChannel(sea, dockMap);
                    })
            ).start();
        }
    }
}