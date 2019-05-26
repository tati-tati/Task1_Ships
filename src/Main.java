import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args){
        Sea sea = new Sea();
        Channel channel = new Channel();
        Map<Ship.Type, Dock> dockMap = new HashMap<>();
        for (Ship.Type type : Ship.Type.values()){
            dockMap.put(type, new Dock(type));
        }
        channel.openChannel(sea, dockMap);
    }
}