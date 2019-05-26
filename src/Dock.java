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

    public boolean isBusy() {
        return isBusy;
    }

    public synchronized void getShip(Ship ship){
        isBusy = true;
        System.out.println("Current thread : " + Thread.currentThread().getName() +
                "Dock : " + this.toString() + " " +
                "Got new ship : " + ship.toString());
        int shipCapacity = ship.getCapacity() - ship.getCurrFilling();
        for (int i = 0 ; i < shipCapacity/VELOCITY_IN_SECOND; i++){
            ship.setCurrFilling(VELOCITY_IN_SECOND);
        }
        isBusy = false;
        System.out.println("Dock : " + this.toString() + " " +
                "Let ship go : " + ship.toString());
//         notifyAll();
    }

    public String toString(){
        return "Dock <" + type + ", " + isBusy + ">";
    }
}