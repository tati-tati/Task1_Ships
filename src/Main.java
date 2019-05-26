public class Main {
    public static void main(String[] args){
        Sea sea = new Sea();
        Channel channel = new Channel();

        //Thread to fill channel while there's a place
        new Thread(() -> {
            System.out.println("New thread is invoked : " + Thread.currentThread().getName());
//            int i = 0;
            while (true){
                Ship ship = sea.generateRandomShip();
                ship.goToChannel(channel);
//                i++;
            }
        }).start();

        // 3 thread for each dock's working
        for (int i = 0; i < 3; i++){
            Ship.Type type = i == 0 ? Ship.Type.A : i == 1 ? Ship.Type.B : Ship.Type.C;
            new Thread(() -> {
                System.out.println("New thread is invoked : " + Thread.currentThread().getName());
                Dock dock = new Dock(type);
                dock.getShip(channel);
            }).start();
        }
    }
}