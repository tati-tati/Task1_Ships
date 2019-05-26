public class Dock {
    private final int VELOCITY_IN_SECOND = 10;
    private Ship.Type type;
    private volatile boolean isBusy = false;

    public Dock(Ship.Type type) {
        this.type = type;
    }

    public Ship.Type getType() {
        return type;
    }



//    public synchronized void getShip(Ship ship){
//        isBusy = true;
//        System.out.println("Current thread : " + Thread.currentThread().getName() +
//                "Dock : " + this.toString() + " " +
//                "Got new ship : " + ship.toString());
//        int shipCapacity = ship.getCapacity() - ship.getCurrFilling();
//        for (int i = 0 ; i < shipCapacity/VELOCITY_IN_SECOND; i++){
//            ship.setCurrFilling(VELOCITY_IN_SECOND);
//        }
//        isBusy = false;
//        System.out.println("Dock : " + this.toString() + " " +
//                "Let ship go : " + ship.toString());
////         notifyAll();
//    }

    public String toString(){
        return "Dock <" + type + ", " + isBusy + ">";
    }

    public void getShip(Channel channel){
        while (true){
            Ship ship = channel.sendNewShip(getType());
            if (ship != null){
                System.out.println("Current thread : " +
                        Thread.currentThread().getName() +
                        "Dock : " + toString() + " " +
                        "Got new ship : " + ship.toString());
                try {
                    Thread.sleep(ship.getCapacity() / VELOCITY_IN_SECOND * 1000);
                    ship.setCurrFilling(ship.getCapacity());
                    System.out.println("Dock : " + toString() + " " +
                            "Let ship go : " + ship.toString());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}