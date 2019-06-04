public class Main {
    public static void main(String[] args) {
        Sea sea = new Sea();
        Channel channel = new Channel();

        //Thread to fill channel while there's a place. Ships are generated one by one
        new Thread(() -> {
            System.out.println("New thread is invoked : " + Thread.currentThread().getName());
            while (true){
                sea.generateRandomShip().setChannel(channel).run();
            }
        }).start();

        // 3 thread for each dock's working
        for (int i = 0; i < 3; i++){
            Ship.Type type = i == 0 ? Ship.Type.A : i == 1 ? Ship.Type.B : Ship.Type.C;
            new Dock(type).setChannel(channel).start();
        }
    }
}
