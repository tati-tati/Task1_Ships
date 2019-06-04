public class Ship implements Runnable{
    private int capacity;
    private int currFilling = 0;
    private Type type;
    private Channel channel;

    public Ship(int capacity, Type type) {
        this.capacity = capacity;
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public Type getType() {
        return type;
    }

    public void setCurrFilling(int currFilling) {
        this.currFilling += currFilling;
    }

    public String toString(){
        return "Ship <" + type + ", " + capacity + ", " + currFilling + ">";
    }

    @Override
    public void run() {
        channel.shipIsArriving(this);
    }

    public Ship setChannel(Channel channel) {
        this.channel = channel;
        return this;
    }

    public enum Type{
        A,
        B,
        C
    }
}
