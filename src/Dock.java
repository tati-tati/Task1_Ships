public class Dock extends Thread {
    private final int VELOCITY_IN_SECOND = 10;
    private Ship.Type type;
    private Channel channel;

    public Dock(Ship.Type type) {
        this.type = type;
    }

    public Ship.Type getType() {
        return type;
    }

    public String toString(){
        return "Dock <" + type + ">";
    }

    public Dock setChannel(Channel channel){
        this.channel = channel;
        return this;
    }

    @Override
    public void run() {
      System.out.println("New thread is invoked : " + Thread.currentThread().getName());
        while (true){
            Ship ship = channel.shipIsLeaving(getType());
            if (ship != null){
                System.out.println(toString() + " get " + ship.toString() +
                        " thread : " + Thread.currentThread().getName());
                try {
                    Thread.sleep(ship.getCapacity() / VELOCITY_IN_SECOND * 1000);
                    ship.setCurrFilling(ship.getCapacity());
                    System.out.println(toString() + " let go " + ship.toString() + " thread : " +
                            Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
